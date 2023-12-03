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
    private String id;

    public CartItem(String productName, String productId, int qty) {
        this.productName = productName;
        this.productId = productId;
        this.qty = qty;
        this.id = UUID.randomUUID().toString();
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
