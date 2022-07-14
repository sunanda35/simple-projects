package com.stackroute.newsapp.userservice.repository;

import com.stackroute.newsapp.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public  User findByUsername(String username);
}
