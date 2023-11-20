package com.example.project.repository;

import com.example.project.repository.model.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ReviewRepository extends MongoRepository<Review, String> {
    @Query("{id:'?0'}")
    Review findItemById(String id);

    public long count();
}
