package com.example.project.entity;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> cartItemList;

    public ShoppingCart(List<CartItem> cartItems) {
        this.cartItemList = cartItems;
    }

    public double getTotal(){
        double cartTotal = 0;
        for (CartItem item : this.cartItemList){
            cartTotal = cartTotal + item.getSubTotal();
        }
        return cartTotal;
    }

    public boolean isEmpty(){
        return cartItemList.isEmpty();
    }

    public void removeCartItem(CartItem cartItem){
        cartItemList.removeIf(item -> item.getId() == cartItem.getId());
    }

    public void clearCart(){
        cartItemList.clear();
    }

    public int getItemCount(){
        return cartItemList.size();
    }

    public List<CartItem> getCartItemList(){
        return this.cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList){
        this.cartItemList = cartItemList;
    }

}
