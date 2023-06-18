package net.crowear.shop.domain.service;

import com.google.inject.Inject;

import net.crowear.shop.domain.model.Role;
import net.crowear.shop.domain.repository.AbstractJpaRepository;
import net.crowear.shop.domain.repository.RoleRepository;

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
