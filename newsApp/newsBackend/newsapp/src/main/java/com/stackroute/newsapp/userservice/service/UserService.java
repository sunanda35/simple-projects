package com.stackroute.newsapp.userservice.service;

import com.stackroute.newsapp.userservice.model.User;
import com.stackroute.newsapp.userservice.model.UserRole;

import java.util.Set;

public interface UserService {

    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    public User getUser(String username);

    //delete user by id
    public void deleteUser(long userId);

    //update API

}
