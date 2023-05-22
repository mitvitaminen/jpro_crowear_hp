package net.crowear.shop.domain.service;

import com.google.inject.Inject;

import net.crowear.shop.domain.model.Message;
import net.crowear.shop.domain.repository.AbstractJpaRepository;
import net.crowear.shop.domain.repository.MessageRepository;

public class MessageServiceImpl implements AbstractJpaService<Message, Long> {

   private final MessageRepository repository;

   @Inject
   public MessageServiceImpl(final MessageRepository repository) {
      this.repository = repository;
   }

   @Override
   public AbstractJpaRepository<Message, Long> getRepository() {
      return repository;
   }

}
