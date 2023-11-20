package com.example.project.repository.model.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

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

    @DocumentReference
    private List<Product> productList;

    public ShoppingCart(List<Product> productList) {
        this.productList = productList;
    }

    public double getTotal(){
        double cartTotal = 0;
        for (Product item : this.productList){
            cartTotal = cartTotal + item.getPrice();
        }
        return cartTotal;
    }

    public boolean isEmpty(){
        return productList.isEmpty();
    }

    public void removeCartItem(Product product){
        productList.removeIf(item -> item.getId() == product.getId());
    }

    public void clearCart(){
        productList.clear();
    }

    public int getItemCount(){
        return productList.size();
    }

    public List<Product> getProductList(){
        return this.productList;
    }

    public void setProductList(List<Product> productList){
        this.productList = productList;
    }

}
