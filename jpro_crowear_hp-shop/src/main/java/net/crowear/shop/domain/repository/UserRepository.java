package net.crowear.shop.domain.repository;

import com.google.inject.Inject;
import com.google.inject.Provider;

import net.crowear.shop.domain.model.User;
import jakarta.persistence.EntityManager;

public class UserRepository implements AbstractJpaRepository<User, Long> {

   private final Provider<EntityManager> entityManagerProvider;

   @Inject
   public UserRepository(final Provider<EntityManager> entityManagerProvider) {
      this.entityManagerProvider = entityManagerProvider;
   }

   @Override
   public EntityManager getEntityManager() {
      return entityManagerProvider.get();
   }

   @Override
   public Class<User> getType() {
      return User.class;
   }

}
