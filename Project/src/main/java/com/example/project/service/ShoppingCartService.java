package com.example.project.service;

import com.example.project.repository.model.entity.Product;
import com.example.project.repository.model.entity.ShoppingCart;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RequestMapping("/cart")
public class ShoppingCartService {

    private final List<ShoppingCart> carts = new ArrayList<>();

    public ShoppingCart getCartByUserId(String userId) {
        return carts.stream()
                .filter(cart -> cart.getUserId().equals(userId))
                .findFirst()
                .orElseGet(() -> {
                    ShoppingCart newCart = new ShoppingCart(userId);
                    carts.add(newCart);
                    return newCart;
                });
    }

    public void addItem(String userId, Long productId, String productName, int quantity) {
        ShoppingCart cart = getCartByUserId(userId);
        cart.addItem(productId, productName, quantity);
    }

    public void removeItem(String userId, Long productId) {
        ShoppingCart cart = getCartByUserId(userId);
        cart.removeItem(productId);
    }

    public void clearCart(String userId) {
        ShoppingCart cart = getCartByUserId(userId);
        cart.clear();
    }
}
