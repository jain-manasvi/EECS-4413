package com.example.project.repository.model.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class Order {
    @Id
    private String id;
    private double totalAmount;
    private Address shippingAddress;
    private ShoppingCart cart;
    private double orderTotal;
    private Shipment shipment;
    private Payment payment;
    private String userId;
    private List<Product> productItems;

    public Order(double totalAmount, Address shippingAddress, ShoppingCart cart, double orderTotal, Shipment shipment, Payment payment, String userId) {
        this.totalAmount = totalAmount;
        this.shippingAddress = shippingAddress;
        this.cart = cart;
        this.orderTotal = orderTotal;
        this.shipment = shipment;
        this.payment = payment;
        this.userId = userId;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public List<Product> getProductItems() {
        return productItems;
    }

    public void setProductItems(List<Product> productItems) {
        this.productItems = productItems;
    }
}
