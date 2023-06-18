package net.chrisrocholl.homepage.domain.service;

import java.util.Optional;

import net.chrisrocholl.homepage.domain.model.User;

public interface UserService extends AbstractJpaService<User, Long> {

   Optional<User> findByName(String username);

}
