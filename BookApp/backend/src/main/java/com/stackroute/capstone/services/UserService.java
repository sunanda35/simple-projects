package com.stackroute.capstone.services;


import java.util.List;
import java.util.Optional;
import com.stackroute.capstone.model.User;

public interface UserService {

  User register(User user);

  Optional<User> login(String userName, String password);

  List<User> getAllUsers();

  String getToken(User user);

  boolean validateToken(String token);

}
