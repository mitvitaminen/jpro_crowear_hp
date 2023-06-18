package net.chrisrocholl.homepage.domain.service;

import com.google.inject.Inject;

import net.chrisrocholl.homepage.domain.model.Permission;
import net.chrisrocholl.homepage.domain.repository.AbstractJpaRepository;
import net.chrisrocholl.homepage.domain.repository.PermissionRepository;

public class PermissionServiceImpl implements AbstractJpaService<Permission, Long> {

   private final PermissionRepository permissionRepository;

   @Inject
   public PermissionServiceImpl(final PermissionRepository permissionRepository) {
      this.permissionRepository = permissionRepository;
   }

   @Override
   public AbstractJpaRepository<Permission, Long> getRepository() {
      return permissionRepository;
   }

}
