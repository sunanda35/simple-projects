package com.walmart.user_auth.repo;

import com.walmart.user_auth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByUserNameAndPassword(String username, String password);
    Optional <User> findByEmail(String email);
    Optional <User> findByUserName(String username);

}
