package com.example.project.service;

import com.example.project.ProjectApplication;
import com.example.project.repository.model.entity.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@RequestMapping("/cart")
@Service
public class ShoppingCartService {

    private final List<ShoppingCart> carts = new ArrayList<>();

    public ShoppingCart getCartByUserId(String userId) {
        if(userId != null && !userId.isEmpty()){
            return carts.stream()
                    .filter(cart -> cart.getUserId().equals(userId))
                    .findFirst()
                    .orElseGet(() -> {
                        ShoppingCart newCart = new ShoppingCart(userId);
                        carts.add(newCart);
                        return newCart;
                    });
        }
        else{
            ProjectApplication.isSignedIn = false;
            return null;
        }

    }

    public ShoppingCart addItem(String userId, String productId, String productName, int quantity) {
        ShoppingCart cart = getCartByUserId(userId);
        cart.addItem(productId, productName, quantity);
        return cart;
    }

    public ShoppingCart removeItem(String userId, String productId) {
        ShoppingCart cart = getCartByUserId(userId);
        cart.removeCartItem(productId);
        return cart;
    }

    public ShoppingCart clearCart(String userId) {
        ShoppingCart cart = getCartByUserId(userId);
        cart.clearCart();
        return cart;
    }

    public ShoppingCart updateItemQuantity(String userId, String productId, int change) {
        ShoppingCart cart = getCartByUserId(userId);
        cart.updateItemQuantity(productId, change);
        return cart;
    }
}
