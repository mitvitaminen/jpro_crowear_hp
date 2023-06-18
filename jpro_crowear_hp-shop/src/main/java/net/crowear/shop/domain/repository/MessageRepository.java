package net.chrisrocholl.homepage.domain.repository;

import com.google.inject.Inject;
import com.google.inject.Provider;

import jakarta.persistence.EntityManager;
import net.chrisrocholl.homepage.domain.model.Message;

public class MessageRepository implements AbstractJpaRepository<Message, Long> {

   private final Provider<EntityManager> entityManagerProvider;

   @Inject
   public MessageRepository(final Provider<EntityManager> entityManagerProvider) {
      this.entityManagerProvider = entityManagerProvider;
   }

   @Override
   public EntityManager getEntityManager() {
      return entityManagerProvider.get();
   }

   @Override
   public Class<Message> getType() {
      return Message.class;
   }

}
