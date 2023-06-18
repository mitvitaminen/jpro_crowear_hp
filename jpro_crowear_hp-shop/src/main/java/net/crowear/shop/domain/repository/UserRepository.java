package net.chrisrocholl.homepage.domain.repository;

import com.google.inject.Inject;
import com.google.inject.Provider;

import jakarta.persistence.EntityManager;
import net.chrisrocholl.homepage.domain.model.User;

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
