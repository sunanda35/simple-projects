package com.walmart.user_auth.service;


import com.walmart.user_auth.domain.User;
import com.walmart.user_auth.repo.UserRepo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User register(User user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<User> login(String userName, String password) {
        Optional <User> user = userRepo.findByEmail(userName);
        if (user.isEmpty()) user = userRepo.findByUserName(userName);
        if(!user.isPresent()){
            return user;
        }
        return userRepo.findByUserNameAndPassword(user.get().getUserName(), password);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public String getToken(User user) {
        String token = null;
        token = Jwts
                .builder().setSubject(user.getUserName()).claim("user", user.getUserName())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "myPassword").compact();
        return token;
    }

    @Override
    public boolean validateToken(String token) {
        Claims claims = Jwts
                .parser()
                .setSigningKey("myPassword")
                .parseClaimsJws(token)
                .getBody();
        if (claims != null) {
            return true;
        }
        return false;
    }
}
