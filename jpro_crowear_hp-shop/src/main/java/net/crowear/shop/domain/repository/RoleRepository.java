package net.chrisrocholl.homepage.domain.repository;

import com.google.inject.Inject;
import com.google.inject.Provider;

import jakarta.persistence.EntityManager;
import net.chrisrocholl.homepage.domain.model.Role;

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
