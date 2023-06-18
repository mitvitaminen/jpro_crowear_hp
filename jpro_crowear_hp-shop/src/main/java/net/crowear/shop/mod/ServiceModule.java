package net.chrisrocholl.homepage.mod;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

import net.chrisrocholl.homepage.domain.model.Message;
import net.chrisrocholl.homepage.domain.model.Permission;
import net.chrisrocholl.homepage.domain.model.Role;
import net.chrisrocholl.homepage.domain.service.AbstractJpaService;
import net.chrisrocholl.homepage.domain.service.LocaleManagerService;
import net.chrisrocholl.homepage.domain.service.LocaleManagerServiceImpl;
import net.chrisrocholl.homepage.domain.service.MessageServiceImpl;
import net.chrisrocholl.homepage.domain.service.PermissionServiceImpl;
import net.chrisrocholl.homepage.domain.service.RoleServiceImpl;
import net.chrisrocholl.homepage.domain.service.TestdataService;
import net.chrisrocholl.homepage.domain.service.TestdataServiceImpl;
import net.chrisrocholl.homepage.domain.service.UserService;
import net.chrisrocholl.homepage.domain.service.UserServiceImpl;

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
