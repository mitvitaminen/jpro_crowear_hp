package net.crowear.shop.domain.repository;

import com.google.inject.Inject;
import com.google.inject.Provider;

import net.crowear.shop.domain.model.Role;
import jakarta.persistence.EntityManager;

public class RoleRepository implements AbstractJpaRepository<Role, Long> {

   private final Provider<EntityManager> entityManagerProvider;

   @Inject
   public RoleRepository(final Provider<EntityManager> entityManagerProvider) {
      this.entityManagerProvider = entityManagerProvider;
   }

   @Override
   public EntityManager getEntityManager() {
      return entityManagerProvider.get();
   }

   @Override
   public Class<Role> getType() {
      return Role.class;
   }

}
