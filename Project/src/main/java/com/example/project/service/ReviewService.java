package com.example.project.service;

import com.example.project.repository.ReviewRepository;
import com.example.project.repository.model.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviewsByProductId(String id) {
        return reviewRepository.getAllReviewsByProductId(id);
    }

    public Review addReview(String ratingNum, String body, String productId){
        Review review = new Review(body, ratingNum, productId);
        return reviewRepository.save(review);
    }
}


