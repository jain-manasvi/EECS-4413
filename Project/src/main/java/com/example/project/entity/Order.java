package com.example.project.entity;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;


public class Order {
    @Id
    private String id;
    private User userId;
    private double totalAmount;
    private Address shippingAddress;
    private List<CartItem> cartItems;
    private Date orderDate;
    private Date shipDate;
    private double orderTotal;
    private Shipment shipment;
    private Payment payment;
    private User user;
    private Status status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
