package net.crowear.shop.mod;

import javax.sql.DataSource;

import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.guice.ShiroModule;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class ShiroAuthModule extends ShiroModule {

   static class RealmProvider implements Provider<Realm> {
      private final PasswordMatcher credentialsMatcher;
      private final DataSource dataSource;

      @Inject
      public RealmProvider(final DataSource dataSource, final PasswordMatcher credentialsMatcher) {
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
      bindRealm().toProvider(RealmProvider.class).asEagerSingleton();
   }

}
