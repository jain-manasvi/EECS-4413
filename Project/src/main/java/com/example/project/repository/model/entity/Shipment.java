package com.example.project.repository.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;

@Document
public class Shipment {
    @Id
    private String id;
    private String orderId;
    private String shippingStatusId;
    private Address deliveryAddress;
    private Order order;
    private Status status;

    public Shipment(String id, String orderId, String shippingStatusId, Address deliveryAddress, Status status) {
        this.id = UUID.randomUUID().toString();
        this.orderId = orderId;
        this.shippingStatusId = shippingStatusId;
        this.deliveryAddress = deliveryAddress;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getShippingStatusId() {
        return shippingStatusId;
    }

    public void setShippingStatusId(String shippingStatusId) {
        this.shippingStatusId = shippingStatusId;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
