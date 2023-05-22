package net.crowear.shop.domain.service;

import com.google.inject.Inject;

import net.crowear.shop.domain.model.Permission;
import net.crowear.shop.domain.repository.AbstractJpaRepository;
import net.crowear.shop.domain.repository.PermissionRepository;

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
