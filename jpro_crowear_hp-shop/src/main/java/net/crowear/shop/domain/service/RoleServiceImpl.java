package net.chrisrocholl.homepage.domain.service;

import com.google.inject.Inject;

import net.chrisrocholl.homepage.domain.model.Role;
import net.chrisrocholl.homepage.domain.repository.AbstractJpaRepository;
import net.chrisrocholl.homepage.domain.repository.RoleRepository;

public class RoleServiceImpl implements AbstractJpaService<Role, Long> {

   private final RoleRepository roleRepository;

   @Inject
   public RoleServiceImpl(final RoleRepository roleRepository) {
      this.roleRepository = roleRepository;
   }

   @Override
   public AbstractJpaRepository<Role, Long> getRepository() {
      return roleRepository;
   }

}
