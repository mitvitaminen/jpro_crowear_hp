package net.crowear.shop.domain.service;

import java.util.Optional;

import net.crowear.shop.domain.model.User;

public interface UserService extends AbstractJpaService<User, Long> {

   Optional<User> findByName(String username);

}
