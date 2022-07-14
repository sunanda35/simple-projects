package com.nutritionist.user_authentication.service;

import com.nutritionist.user_authentication.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    
    User register(User user);

    Optional<User> login(String userName, String password);

    List<User> getAllUsers();

    String getToken(User user);

    boolean validateToken(String token);
}
