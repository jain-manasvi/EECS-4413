package com.example.project.repository.model.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Reviews")
public class Review {
    @Id
    private ObjectId id;
//    @DocumentReference
//    private String productId;
//    @DocumentReference
//    private User user;
    private String body;
    private int rating;
    // Other review-related fields, getters, setters, etc.
    public Review(String body, int rating){
        this.body = body;
        this.rating = rating;
    }
}
