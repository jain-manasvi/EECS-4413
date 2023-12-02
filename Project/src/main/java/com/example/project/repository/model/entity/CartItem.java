package com.example.project.repository.model.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

//Cart item class that holds all the items that are in the cart
@Document
public class CartItem {
    private String productName;
    private String productId;
    private int qty;
    @Id
    private String Id;

    public CartItem(String productName, String productId, int qty) {
        this.productName = productName;
        this.productId = productId;
        this.qty = qty;
        this.Id = UUID.randomUUID().toString();
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
