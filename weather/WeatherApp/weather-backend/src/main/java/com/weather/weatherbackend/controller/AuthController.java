package com.weather.weatherbackend.controller;

import com.weather.weatherbackend.domain.User;
import com.weather.weatherbackend.repo.UserRepo;
import com.weather.weatherbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import com.nutritionistapp.nutritionistbackend.domain.User;
//import com.nutritionistapp.nutritionistbackend.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/v1/users")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;


    public AuthController(UserService userService) {
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
        System.out.println(login);
        // send JWT when login is successful
        String token = userService.getToken(user);
        resposne.put("token", token);
        resposne.put("name", login.get().getName());
        resposne.put("id", String.valueOf(login.get().getId()));
        resposne.put("status", HttpStatus.OK.toString());
        return ResponseEntity.status(HttpStatus.OK).body(resposne);
    }
    @PutMapping("/update-profile")
    public ResponseEntity<?> updateProfile(@RequestBody User user, @RequestParam Integer id){

       var d = userRepo.findById(id);
       d.get().setName(user.getName());
       d.get().setPhone(user.getPhone());
//       userService.

        return ResponseEntity.status(HttpStatus.OK).body("update");
    }
    @PostMapping("/update-password")
    public ResponseEntity<?> updateProfilePass(@RequestBody String oldPass, @RequestBody String newPass, @RequestParam String id){
        return ResponseEntity.status(HttpStatus.OK).body("update");
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
