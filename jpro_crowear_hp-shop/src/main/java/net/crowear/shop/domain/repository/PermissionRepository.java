package net.crowear.shop.domain.repository;

import com.google.inject.Inject;
import com.google.inject.Provider;

import net.crowear.shop.domain.model.Permission;
import jakarta.persistence.EntityManager;

public class PermissionRepository implements AbstractJpaRepository<Permission, Long> {

   private final Provider<EntityManager> entityManagerProvider;

   @Inject
   public PermissionRepository(final Provider<EntityManager> entityManagerProvider) {
      this.entityManagerProvider = entityManagerProvider;
   }

   @Override
   public EntityManager getEntityManager() {
      return entityManagerProvider.get();
   }

   @Override
   public Class<Permission> getType() {
      return Permission.class;
   }

}
