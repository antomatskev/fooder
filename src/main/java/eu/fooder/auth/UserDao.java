package eu.fooder.auth;

import eu.fooder.models.User;

import java.util.Optional;

public interface UserDao {
    Optional<User> selectUserByUsername(String username);
}