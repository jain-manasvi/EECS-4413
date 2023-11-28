package com.example.project.controller;

import com.example.project.repository.model.entity.Product;
import com.example.project.repository.model.entity.ShoppingCart;
import com.example.project.service.ShoppingCartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService service;

    @GetMapping("/")
    public ShoppingCart getCart(HttpSession session){
        return service.getCart((HttpSession) session.getAttribute("userId"));
    }

    @PostMapping("/add")
    public void addToCart(HttpSession session, @RequestBody Product product) {
        ShoppingCart cart = service.getCart((HttpSession) session.getAttribute("userId"));
        cart.addItem(product);
    }

    @PostMapping("/remove")
    public void removeFromCart(HttpSession session, @RequestBody Product product) {
        ShoppingCart cart = service.getCart((HttpSession) session.getAttribute("userId"));
        cart.removeCartItem(product);
    }

    @PostMapping("/clear")
    public void clearCart(HttpSession session) {
        service.clearCart((HttpSession) session.getAttribute("userId"));
    }
}
