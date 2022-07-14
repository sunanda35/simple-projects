package com.stackroute.newsapp.userservice.service.impl;

import com.stackroute.newsapp.userservice.model.User;
import com.stackroute.newsapp.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.userRepository.findByUsername(username);
        if(user==null){
            System.out.println("User not Found");
            throw new UsernameNotFoundException("No user found !! ");
        }
        return user;
    }
}
