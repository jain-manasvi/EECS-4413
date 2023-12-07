package com.example.project.controller;

import com.example.project.repository.model.entity.Review;
import com.example.project.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/write")
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        Review addedReview = reviewService.addReview(review.getRating(), review.getBody(), review.getProductId());
        return ResponseEntity.ok(addedReview);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<Review>> getAllReviewsByProductId(@PathVariable String productId) {
        List<Review> reviews = reviewService.getAllReviewsByProductId(productId);
        return ResponseEntity.ok(reviews);
    }
}

