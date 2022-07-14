package com.walmart.user_auth.controller;

import com.walmart.user_auth.domain.User;
import com.walmart.user_auth.repo.UserRepo;
import com.walmart.user_auth.service.UserService;
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
public class AuthController {


    private UserService userService;

    private UserRepo userRepo;

    @Autowired
    public AuthController(UserService userService, UserRepo userRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
    }



    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(user));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause().getCause().getMessage());
        }
    }
    @GetMapping("/update-user")
    public ResponseEntity<?> updateUser(@RequestParam String pass, @RequestParam Integer id){
        var d = userRepo.findById(id);
        User user = d.get();
        user.setPassword(pass);
        try{
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.register(user));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause().getCause().getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        try{
            Map<String, String> resposne = new HashMap<>();
            Optional<User> login = userService.login(user.getUserName(), user.getPassword());
            System.out.println(login);
            if(!login.isPresent() || login.isEmpty()) {
                resposne.put("message", "Invalid Credentials");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong UserName/Email or Password!!");
            }
            // send JWT when login is successful
            String token = userService.getToken(user);
            resposne.put("token", token);
            resposne.put("userName", login.get().getUserName());
            resposne.put("email", login.get().getEmail());
            resposne.put("id", String.valueOf(login.get().getId()));
            resposne.put("fName", login.get().getFName());
            resposne.put("lName", login.get().getLName());
            resposne.put("status", HttpStatus.OK.toString());
            return ResponseEntity.status(HttpStatus.OK).body(resposne);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause().getCause().getMessage());
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
