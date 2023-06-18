package net.crowear.shop.mod;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

import net.crowear.shop.domain.model.Message;
import net.crowear.shop.domain.model.Permission;
import net.crowear.shop.domain.model.Role;
import net.crowear.shop.domain.service.AbstractJpaService;
import net.crowear.shop.domain.service.LocaleManagerService;
import net.crowear.shop.domain.service.LocaleManagerServiceImpl;
import net.crowear.shop.domain.service.MessageServiceImpl;
import net.crowear.shop.domain.service.PermissionServiceImpl;
import net.crowear.shop.domain.service.RoleServiceImpl;
import net.crowear.shop.domain.service.TestdataService;
import net.crowear.shop.domain.service.TestdataServiceImpl;
import net.crowear.shop.domain.service.UserService;
import net.crowear.shop.domain.service.UserServiceImpl;

public class ServiceModule extends AbstractModule {

   @Override
   protected void configure() {
      super.configure();
      bind(LocaleManagerService.class).to(LocaleManagerServiceImpl.class).asEagerSingleton();
      bind(TestdataService.class).to(TestdataServiceImpl.class).asEagerSingleton();
      bind(new TypeLiteral<AbstractJpaService<Message, Long>>() {
      }).to(MessageServiceImpl.class).asEagerSingleton();
      bind(new TypeLiteral<AbstractJpaService<Permission, Long>>() {
      }).to(PermissionServiceImpl.class).asEagerSingleton();
      bind(new TypeLiteral<AbstractJpaService<Role, Long>>() {
      }).to(RoleServiceImpl.class).asEagerSingleton();
      bind(UserService.class).to(UserServiceImpl.class).asEagerSingleton();
   }

}
