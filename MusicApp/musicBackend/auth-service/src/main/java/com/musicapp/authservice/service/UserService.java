package com.musicapp.authservice.service;


import com.musicapp.authservice.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    
    User register(User user);

    Optional<User> login(String userName, String password);

    List<User> getAllUsers();

    String getToken(User user);

    boolean validateToken(String token);
}
