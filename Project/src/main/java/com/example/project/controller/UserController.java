package com.example.project.controller;
import com.example.project.repository.model.entity.User;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

//    @GetMapping("/{email}")
//    @PostMapping("/sign-in")
//    public ResponseEntity<User> getUserByEmail(@RequestBody String email, @RequestBody String password) {
//        User user = userService.loginUser(email, password);
//        System.out.println(user.toString());
//        return user != null ? ResponseEntity.ok(user) : null;
//    }

    @PostMapping("/sign-in")
    public ResponseEntity<User> loginUserByEmail(@RequestBody User userReq){
        User user = userService.loginUser(userReq.getEmail(), userReq.getPassword());
        System.out.println(user.toString());
        return user != null ? ResponseEntity.ok(user) : null;
    }
//    public ResponseEntity<User> getCurrentUser(){
//        User user = userService.
//    }



}
