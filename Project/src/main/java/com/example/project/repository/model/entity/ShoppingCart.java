package com.example.project.repository.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//    public double getTotal(){
//        double cartTotal = 0;
//        for (CartItem item : this.cartItemList){
//            cartTotal = cartTotal + item.getSubTotal();
//        }
//        return cartTotal;
//    }

public class ShoppingCart {

    @Id
    private String id;
    private String userId;
//    @DocumentReference
    //Cart item has the individual items in the cart
    private List<CartItem> cart;

    public ShoppingCart(String userId) {
        this.cart = new ArrayList<>();
        this.userId = userId;
        this.id = UUID.randomUUID().toString();
    }

    public boolean isEmpty(){
        return cart.isEmpty();
    }

    public void removeCartItem(String productId){
        System.out.println("Remove cart item: " + productId);
        cart.removeIf(item -> item.getProductId().equals(productId));
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

    public void updateItemQuantity(String productId, int change){
        for (CartItem item : cart){
            if(item.getProductId().equals(productId)){
                int newQty = item.getQty() + change;
                if(newQty > 0) {
                    item.setQty(newQty);
                } else {
                    cart.remove(item);
                }
                break;
            }
        }
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
