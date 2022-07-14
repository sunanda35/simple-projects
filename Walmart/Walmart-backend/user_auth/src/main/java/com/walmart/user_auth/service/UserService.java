package com.walmart.user_auth.service;

import com.walmart.user_auth.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User register(User user);

    Optional<User> login(String userName, String password);

    List<User> getAllUsers();


    String getToken(User user);

    boolean validateToken(String token);
}
