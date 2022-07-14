package com.stackroute.capstone.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.stackroute.capstone.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.capstone.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserServiceImpl implements UserService {

  private RegistrationRepository registrationRepository;

  @Autowired
  public UserServiceImpl(RegistrationRepository registrationRepository) {
    this.registrationRepository = registrationRepository;
  }

  @Override
  public User register(User user) {
    return registrationRepository.save(user);
  }

  @Override
  public Optional<User> login(String userName, String password) {
    return registrationRepository.findByUserNameAndPassword(userName, password);
  }

  @Override
  public List<User> getAllUsers() {
    return registrationRepository.findAll();
  }

  @Override
  public String getToken(User user) {
    String token = null;
    token = Jwts
      .builder().setSubject(user.getUserName()).claim("user", user.getPassword())
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
