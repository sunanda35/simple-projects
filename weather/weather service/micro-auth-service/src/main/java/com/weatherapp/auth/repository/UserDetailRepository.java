package com.weatherapp.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weatherapp.auth.model.User;

import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<User,Integer> {


    Optional<User> findByUsername(String name);

}
