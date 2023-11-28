package com.example.project.repository.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.ArrayList;
import java.util.List;
//
//public class ShoppingCart {
//    private List<CartItem> cartItemList;
//
//    public ShoppingCart(List<CartItem> cartItems) {
//        this.cartItemList = cartItems;
//    }
//
//    public double getTotal(){
//        double cartTotal = 0;
//        for (CartItem item : this.cartItemList){
//            cartTotal = cartTotal + item.getSubTotal();
//        }
//        return cartTotal;
//    }
//
//    public boolean isEmpty(){
//        return cartItemList.isEmpty();
//    }
//
//    public void removeCartItem(CartItem cartItem){
//        cartItemList.removeIf(item -> item.getId() == cartItem.getId());
//    }
//
//    public void clearCart(){
//        cartItemList.clear();
//    }
//
//    public int getItemCount(){
//        return cartItemList.size();
//    }
//
//    public List<CartItem> getCartItemList(){
//        return this.cartItemList;
//    }
//
//    public void setCartItemList(List<CartItem> cartItemList){
//        this.cartItemList = cartItemList;
//    }
//
//}
@Document
public class ShoppingCart {

    @Id
    private String id;
    private String userId;
    @DocumentReference
    private List<CartItem> cart;

    public ShoppingCart(String userId) {
        this.cart = new ArrayList<>();
        this.userId = userId;
    }

    public boolean isEmpty(){
        return cart.isEmpty();
    }

    public void removeCartItem(Product product){
        cart.removeIf(item -> item.getId() == product.getId());
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

    public void addItem(Product product) {
        this.cart.add(this.getItemCount(), product);
    }

    public String getUserId() {
        return userId;
    }
}
