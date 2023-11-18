package com.example.project.entity;

import java.math.BigDecimal;

public class CartItem {
    private Product product;
    private User user;
    private Order order;
    private int qty;
    private String Id;

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getId() {
        return Id;
    }

    public double getSubTotal(){
        return product.getPrice() * qty;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setId(String id) {
        Id = id;
    }
}
