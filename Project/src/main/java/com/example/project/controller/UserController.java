package com.example.project.controller;
import com.example.project.ProjectApplication;
import com.example.project.repository.model.entity.ShoppingCart;
import com.example.project.repository.model.entity.User;
import com.example.project.service.ShoppingCartService;
import com.example.project.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
//@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final ShoppingCartService cartService;

    @Autowired
    public UserController(UserService userService, ShoppingCartService cartService) {
        this.userService = userService;
        this.cartService = cartService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<User> loginUserByEmail(@RequestBody User userReq, HttpSession session){
        User user = userService.loginUser(userReq.getEmail());
        if(!user.getEmail().equals("baduser@gmail.com")){
            if(user.getPassword().equals(userReq.getPassword())){
                ProjectApplication.isSignedIn = true;
                ShoppingCart cart = this.cartService.getCartByUserId(user.getId());
                System.out.println(cart.toString());
                session.setAttribute("cart", cart);
                session.setAttribute("fName", user.getfName());
                session.setAttribute("lName", user.getlName());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("userId", user.getId());
                session.setAttribute("isSignedIn", true);
                return new ResponseEntity<>(user, HttpStatus.OK);
            }

        }

        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }


//    public ResponseEntity<User> getCurrentUser(){
//        User user = userService.
//    }



}
