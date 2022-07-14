package com.stackroute.capstone.controllers;

import com.stackroute.capstone.model.User;
import com.stackroute.capstone.repository.RegistrationRepository;
import com.stackroute.capstone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping()
public class RegistrationController {

  private UserService userService;

  @Autowired
  private RegistrationRepository registrationRepository;
  @Autowired
  public RegistrationController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public ResponseEntity<User> register(@RequestBody User user){
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(user));
  }

  @PostMapping("/login")
  public ResponseEntity<Map<String, String>> login(@RequestBody User user){
    Map<String, String> resposne = new HashMap<>();
    Optional<User> login = userService.login(user.getUserName(), user.getPassword());
    if(!login.isPresent()) {
      resposne.put("message", "Invalid Credentials");
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
    // send JWT when login is successful
    String token = userService.getToken(user);
    resposne.put("token", token);
    resposne.put("status", HttpStatus.OK.toString());
    return ResponseEntity.status(HttpStatus.OK).body(resposne);
  }

  @GetMapping(value = {"", "/edit-password"})
  public ResponseEntity<?> editPassword(@RequestParam("usr") String usr,@RequestParam("oldP") String oldP,@RequestParam("newP") String newP ){
    try{
      Optional<User> user = registrationRepository.findByUserNameAndPassword(usr, oldP);
      System.out.println(user.get().getPassword());
      user.get().setPassword(newP);
      System.out.println(user.get().getPassword());
      this.registrationRepository.save(user.get());
      return ResponseEntity.status(HttpStatus.OK).body(null);
    }catch (Exception e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("something went wrong!!");
    }
  }

  @GetMapping(value={"", "/"})
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> allUsers = userService.getAllUsers();
    if(allUsers.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    return ResponseEntity.status(HttpStatus.OK).body(allUsers);
  }


  @PostMapping("/authenticate")
  public ResponseEntity<Map<String, String>> authenticate(@RequestHeader("Authorization") String token) {
    Map<String, String> response = new HashMap<>();
    if(token.isBlank() || token.isEmpty()) {
      response.put("message", "Invalid token");
      response.put("status", HttpStatus.UNAUTHORIZED.toString());
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
    if(!userService.validateToken(token.substring(7))) {
      response.put("message", "Invalid token");
      response.put("status", HttpStatus.UNAUTHORIZED.toString());
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
    response.put("message", "Valid token");
    response.put("status", HttpStatus.OK.toString());
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }


}

