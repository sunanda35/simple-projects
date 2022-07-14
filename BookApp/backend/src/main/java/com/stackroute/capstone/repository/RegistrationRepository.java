package com.stackroute.capstone.repository;

import com.stackroute.capstone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<User, Integer> {

  Optional<User> findByUserNameAndPassword(String userName, String password);

}
