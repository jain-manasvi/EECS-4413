package com.example.project.service;

import com.example.project.repository.model.entity.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@RequestMapping("/cart")
@Service
public class ShoppingCartService {

    private final List<ShoppingCart> carts = new ArrayList<>();

/*    //@Autowired
    public ShoppingCartService(ShoppingCartRepository repository){
        this.repository = repository;*/
;


//
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

    public void addItem(String userId, String productId, String productName, int quantity) {
        ShoppingCart cart = getCartByUserId(userId);
        cart.addItem(productId, productName, quantity);
    }

    public void removeItem(String userId, String productId) {
        ShoppingCart cart = getCartByUserId(userId);
        cart.removeCartItem(productId);
    }

    public void clearCart(String userId) {
        ShoppingCart cart = getCartByUserId(userId);
        cart.clearCart();
    }
}
