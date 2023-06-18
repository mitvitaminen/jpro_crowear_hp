package net.chrisrocholl.homepage.domain.service;

import com.google.inject.Inject;

import net.chrisrocholl.homepage.domain.model.Message;
import net.chrisrocholl.homepage.domain.repository.AbstractJpaRepository;
import net.chrisrocholl.homepage.domain.repository.MessageRepository;

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
