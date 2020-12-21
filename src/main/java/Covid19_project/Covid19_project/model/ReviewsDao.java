package com.example.covidProject.dao;

import com.example.covidProject.model.Review;

import java.util.List;
import java.util.UUID;

public interface ReviewsDao {
    int insertReview(Review review);

    List<Review> selectAllReviews(String country);

    int deleteReview(Review review);

    int updateReview(Review review);

}
