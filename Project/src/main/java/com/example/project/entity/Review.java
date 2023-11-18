package com.example.project.entity;

import org.springframework.data.annotation.Id;

public class Review {
    @Id
    private String id;
    private String productId;
    private String userId;
    private String comment;
    private int rating;
    // Other review-related fields, getters, setters, etc.
}
