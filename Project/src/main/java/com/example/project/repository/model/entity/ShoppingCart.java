package com.example.project.repository.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.ArrayList;
import java.util.List;

//    public double getTotal(){
//        double cartTotal = 0;
//        for (CartItem item : this.cartItemList){
//            cartTotal = cartTotal + item.getSubTotal();
//        }
//        return cartTotal;
//    }

@Document
public class ShoppingCart {

    @Id
    private String id;
    private String userId;
//    @DocumentReference
    private List<CartItem> cart;

    public ShoppingCart(String userId) {
        this.cart = new ArrayList<>();
        this.userId = userId;
    }

    public boolean isEmpty(){
        return cart.isEmpty();
    }

    public void removeCartItem(String productId){
        cart.removeIf(item -> item.getId() == productId);
    }

    public void clearCart(){
        cart.clear();
    }

    public int getItemCount(){
        return cart.size();
    }

    public List<CartItem> getCart(){
        return this.cart;
    }

    public void setCart(List<CartItem> cart){
        this.cart = cart;
    }

    public void addItem(String productId, String productName, int qty){
        for (CartItem item: cart){
            if(item.getProductId().equals(productId)){
                item.setQty(item.getQty() + qty);
                return;
            }
        }
        
        CartItem item = new CartItem(productName, productId, qty);
        this.cart.add(item);
    }

    public String getUserId() {
        return userId;
    }
}
