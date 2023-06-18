package net.chrisrocholl.homepage.security.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.Argon2Factory.Argon2Types;

public class Argon2CredentialsMatcher implements CredentialsMatcher {
   public static final int ARGON2_ITERATIONS = 4;
   public static final int ARGON2_MEMORY = 1024 * 1024;
   public static final int ARGON2_PARALLELISM = 4;

   @Override
   public boolean doCredentialsMatch(final AuthenticationToken token, final AuthenticationInfo info) {
      final Argon2 argon2 = Argon2Factory.create(Argon2Types.ARGON2id);

      final UsernamePasswordToken upt = (UsernamePasswordToken) token;
      return argon2.verify(new String((char[]) info.getCredentials()), upt.getPassword());
   }

}
