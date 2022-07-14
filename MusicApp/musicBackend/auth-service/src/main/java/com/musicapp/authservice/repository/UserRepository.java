package com.musicapp.authservice.repository;

import com.musicapp.authservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserNameAndPassword(String username, String password);

}
