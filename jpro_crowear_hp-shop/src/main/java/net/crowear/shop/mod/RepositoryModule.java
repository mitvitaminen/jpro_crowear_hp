package net.crowear.shop.mod;

import com.google.inject.Binder;

import net.crowear.shop.domain.repository.MessageRepository;
import net.crowear.shop.domain.repository.PermissionRepository;
import net.crowear.shop.domain.repository.RoleRepository;
import net.crowear.shop.domain.repository.UserRepository;

public class RepositoryModule implements com.google.inject.Module {
   @Override
   public void configure(final Binder binder) {
      binder.bind(MessageRepository.class).asEagerSingleton();
      binder.bind(PermissionRepository.class).asEagerSingleton();
      binder.bind(RoleRepository.class).asEagerSingleton();
      binder.bind(UserRepository.class).asEagerSingleton();
   }

}
