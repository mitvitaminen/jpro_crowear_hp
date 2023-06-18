package net.chrisrocholl.homepage.mod;

import javax.sql.DataSource;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.guice.ShiroModule;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;

import com.google.inject.Inject;
import com.google.inject.Provider;

import net.chrisrocholl.homepage.security.shiro.Argon2CredentialsMatcher;

public class ShiroAuthModule extends ShiroModule {

   static class CredentialsMatcherProvider implements Provider<CredentialsMatcher> {
      @Override
      public CredentialsMatcher get() {
         return new Argon2CredentialsMatcher();
      }
   }

   static class RealmProvider implements Provider<Realm> {
      private final CredentialsMatcher credentialsMatcher;
      private final DataSource dataSource;

      @Inject
      public RealmProvider(final DataSource dataSource, final CredentialsMatcher credentialsMatcher) {
         this.dataSource = dataSource;
         this.credentialsMatcher = credentialsMatcher;
      }

      @Override
      public Realm get() {
         final JdbcRealm realm = new JdbcRealm();
         realm.setAuthenticationQuery("select password from users where username = ?");
         realm.setUserRolesQuery("SELECT r.rolename FROM roles r INNER JOIN users_roles ur ON roles_id = r.id "
               + "INNER JOIN users u ON u.id = ur.roles_id WHERE u.username = ?");
         realm.setPermissionsQuery("SELECT p.permission FROM permissions p "
               + "INNER JOIN roles_permissions rp ON rp.permissions_id = p.id "
               + "INNER JOIN roles r ON r.id = rp.roles_id WHERE r.rolename = ?");
         realm.setPermissionsLookupEnabled(true);
         realm.setCredentialsMatcher(credentialsMatcher);
         realm.setDataSource(dataSource);
         return realm;
      }
   }

   @Override
   public void configureShiro() {
      bind(CredentialsMatcher.class).toProvider(CredentialsMatcherProvider.class).asEagerSingleton();
      bindRealm().toProvider(RealmProvider.class).asEagerSingleton();
   }

}
