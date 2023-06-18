package net.chrisrocholl.homepage.domain.service;

import java.util.Optional;

import com.google.inject.Inject;

import net.chrisrocholl.homepage.domain.model.User;
import net.chrisrocholl.homepage.domain.repository.AbstractJpaRepository;
import net.chrisrocholl.homepage.domain.repository.UserRepository;

public class UserServiceImpl implements UserService {

   private final UserRepository userRepository;

   @Inject
   public UserServiceImpl(final UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Override
   public Optional<User> findByName(final String username) {
      return userRepository.findByColumnValue("username", username).stream().findAny();
   }

   @Override
   public AbstractJpaRepository<User, Long> getRepository() {
      return userRepository;
   }

}
