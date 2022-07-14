package com.musicapp.authservice.service;

import com.musicapp.authservice.domain.User;
import com.musicapp.authservice.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> login(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName, password);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
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
