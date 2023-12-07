package com.example.project.repository;

import com.example.project.repository.model.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {
//    @Query("{id:'?0'}")
//    Review findItemById(String productId);

    public long count();

    @Query("{productId:'?0'}")
    List<Review> getAllReviewsByProductId(String productId);


}
