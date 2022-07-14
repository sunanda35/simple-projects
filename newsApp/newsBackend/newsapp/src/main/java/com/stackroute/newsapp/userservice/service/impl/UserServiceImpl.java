package com.stackroute.newsapp.userservice.service.impl;

import com.stackroute.newsapp.userservice.helper.UserFoundException;
import com.stackroute.newsapp.userservice.helper.UserNotFoundException;
import com.stackroute.newsapp.userservice.model.User;
import com.stackroute.newsapp.userservice.model.UserRole;
import com.stackroute.newsapp.userservice.repository.RoleRepository;
import com.stackroute.newsapp.userservice.repository.UserRepository;
import com.stackroute.newsapp.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User is already there !!");
            throw new UserFoundException();
        } else {
            //user create
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return null;
    }

    //getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(long userId) {
        this.userRepository.deleteById(userId);
    }

}
