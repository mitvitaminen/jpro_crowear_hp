package net.chrisrocholl.homepage.mod;

import com.google.inject.Binder;

import net.chrisrocholl.homepage.domain.repository.MessageRepository;
import net.chrisrocholl.homepage.domain.repository.PermissionRepository;
import net.chrisrocholl.homepage.domain.repository.RoleRepository;
import net.chrisrocholl.homepage.domain.repository.UserRepository;

public class RepositoryModule implements com.google.inject.Module {
   @Override
   public void configure(final Binder binder) {
      binder.bind(MessageRepository.class).asEagerSingleton();
      binder.bind(PermissionRepository.class).asEagerSingleton();
      binder.bind(RoleRepository.class).asEagerSingleton();
      binder.bind(UserRepository.class).asEagerSingleton();
   }

}
