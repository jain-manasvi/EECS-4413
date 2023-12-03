package com.example.project.controller;

import com.example.project.repository.model.entity.Product;
import com.example.project.repository.model.entity.ShoppingCart;
import com.example.project.service.ShoppingCartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
    private final ShoppingCartService service;

    @Autowired
    public ShoppingCartController(ShoppingCartService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ShoppingCart getCart(HttpSession session){
        
        String userId = (String) session.getAttribute("userId");

        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        return cart;
    }

    @PostMapping("/add")
    public void addToCart(HttpSession session, @RequestBody Product product) {
        System.out.println("Printing session attr: " + session.getAttribute("userId"));
        service.addItem(String.valueOf(session.getAttribute("userId")), product.getId(), product.getName(), product.getQuantity());
        String userId = (String) session.getAttribute("userId");
        System.out.println(userId);
        ShoppingCart cart = service.getCartByUserId(userId);


    }

    @PostMapping("/remove")
    public void removeFromCart(HttpSession session, @RequestBody Product product) {
        service.removeItem((String) session.getAttribute("userId"), product.getId());
    }

    @DeleteMapping("/clear")
    public void clearCart(HttpSession session) {
        service.clearCart(String.valueOf(session.getAttribute("userId")));
    }
}
