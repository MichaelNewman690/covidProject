package com.example.covidProject.api;

import com.example.covidProject.model.Review;
import com.example.covidProject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/api/reviews")
@RestController
public class ReviewsController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewsController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @PostMapping
    public void addReview(@RequestBody Review review){
        reviewService.addReview(review);
    }
    @GetMapping
    public List<Review> getAllReviews(@RequestParam String country){
        return reviewService.getAllReviews(country);
    }
    @DeleteMapping
    public void deleteReview(@RequestBody Review review){
        reviewService.deleteReview(review);
    }
    @PutMapping
    public int updateReview(@RequestBody Review review){
        return reviewService.updateReview(review);
    }
}
