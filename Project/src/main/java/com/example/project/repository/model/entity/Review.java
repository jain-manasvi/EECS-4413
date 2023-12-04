package com.example.project.repository.model.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "Reviews")
public class Review {
    @Id
    private String id;
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
        this.id = UUID.randomUUID().toString();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


}
