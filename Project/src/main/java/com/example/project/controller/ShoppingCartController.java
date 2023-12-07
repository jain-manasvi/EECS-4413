package com.example.project.controller;

import com.example.project.repository.model.entity.Product;
import com.example.project.repository.model.entity.ShoppingCart;
import com.example.project.service.ShoppingCartService;
import com.mongodb.internal.bulk.UpdateRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class ShoppingCartController {
    private final ShoppingCartService service;

    @Autowired
    public ShoppingCartController(ShoppingCartService service) {
        this.service = service;
    }

    @GetMapping("/cart")
    public ResponseEntity<ShoppingCart> getCart(HttpSession session){

        String userId = (String) session.getAttribute("userId");

        ShoppingCart cart = service.getCartByUserId(userId);
//        if(cart == null){
//            session.setAttribute("isUserSignedIn", false);
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }


    public ShoppingCart getCartList(HttpSession session){
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        return cart;
    }

    @PutMapping("/cart/add")
    public ResponseEntity<ShoppingCart> addToCart(HttpSession session, @RequestBody Product product) {
//        System.out.println("Printing session attr: " + session.getAttribute("userId"));
//        service.addItem(String.valueOf(session.getAttribute("userId")), product.getId(), product.getName(), product.getQuantity());
//        String userId = (String) session.getAttribute("userId");
//        System.out.println(userId);
//        ShoppingCart cart = service.getCartByUserId(userId);

        String userId = (String) session.getAttribute("userId");
        //In case userId is null then we know it will create an error, so we set the shopping cart object to null and
        //send a bad request response back to the user, so we can notify them that they need to sign in. This will also
        //avoid null pointer exception
        if(userId == null){
            session.setAttribute("isUserSignedIn", false);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        service.addItem(userId, product.getId(), product.getName(), product.getQuantity());

        // Update the cart attribute in the session after adding an item
        ShoppingCart cart = service.getCartByUserId(userId);
        session.setAttribute("cart", cart);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @DeleteMapping("/cart/remove")
    public ResponseEntity<ShoppingCart> removeFromCart(HttpSession session, @RequestBody Product product) {
        service.removeItem((String) session.getAttribute("userId"), product.getId());
        ShoppingCart cart = service.getCartByUserId((String) session.getAttribute("userId"));
        session.setAttribute("cart", cart);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
//
//    @PutMapping("/cart/update")
//    public ResponseEntity<ShoppingCart> updateCartItemQuantity(HttpSession session, @RequestBody UpdateRequest updateRequest) {
//        String userId = (String) session.getAttribute("userId");
//        service.updateItemQuantity(userId, updateRequest.getProductId(), updateRequest.getChange());
//        ShoppingCart cart = service.getCartByUserId(userId);
//        session.setAttribute("cart", cart);
//        return new ResponseEntity<>(cart, HttpStatus.OK);
//    }

    @DeleteMapping("/cart/clear")
    public ResponseEntity<ShoppingCart> clearCart(HttpSession session) {
        service.clearCart(String.valueOf(session.getAttribute("userId")));
        ShoppingCart cart = service.getCartByUserId((String) session.getAttribute("userId"));
        session.setAttribute("cart", cart);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

//    @GetMapping("/isUserSignedIn")
//    public boolean isUserSignedIn(HttpSession session) {
//        Boolean isSignedIn = (Boolean) session.getAttribute("isSignedIn");
//
//        // If isSignedIn is not null and true, the user is signed in
//        return isSignedIn != null && isSignedIn;
//    }
}
