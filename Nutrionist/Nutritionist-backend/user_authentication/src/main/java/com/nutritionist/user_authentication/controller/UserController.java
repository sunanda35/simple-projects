package com.nutritionist.user_authentication.controller;

import com.nutritionist.user_authentication.domain.User;
import com.nutritionist.user_authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        try{
            var u = userService.register(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(u);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CREATED).body(e.getCause().getCause().getLocalizedMessage());

        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
       try{
           Map<String, String> resposne = new HashMap<>();
           Optional<User> login = userService.login(user.getUserName(), user.getPassword());
           if(!login.isPresent()) {
               resposne.put("message", "Invalid Credentials");
               return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username/Password");
           }
           // send JWT when login is successful
           String token = userService.getToken(user);
           resposne.put("token", token);
           resposne.put("id", String.valueOf(login.get().getId()));
           resposne.put("status", HttpStatus.OK.toString());
           return ResponseEntity.status(HttpStatus.OK).body(resposne);
       }catch (Exception e){
           return ResponseEntity.status(HttpStatus.CREATED).body(e.getCause().getCause().getLocalizedMessage());
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
