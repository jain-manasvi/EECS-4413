package com.example.project.controller;
import com.example.project.repository.model.entity.User;
import com.example.project.service.UserService;
import jakarta.servlet.http.HttpSession;
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

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<User> loginUserByEmail(@RequestBody User userReq, HttpSession session){
        User user = userService.loginUser(userReq.getEmail(), userReq.getPassword());
        if(user != null){
            session.setAttribute("fName", user.getfName());
            session.setAttribute("lName", user.getlName());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("userId", user.getId());
        }
//        System.out.println(session.getAttribute("userId"));
        return user != null ? ResponseEntity.ok(user) : null;
    }
//    public ResponseEntity<User> getCurrentUser(){
//        User user = userService.
//    }



}
