package com.example.covidProject.service;

import com.example.covidProject.dao.ReviewsDao;
import com.example.covidProject.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewsDao reviewsDao;

    @Autowired
    public ReviewService(@Qualifier("postgres") ReviewsDao reviewsDao) {
        this.reviewsDao = reviewsDao;
    }

    public int addReview(Review review){
    return reviewsDao.insertReview(review);
    }

    public List<Review> getAllReviews(String country){
        return reviewsDao.selectAllReviews(country);
    }

    public int deleteReview(Review review){
        return reviewsDao.deleteReview(review);
    }
    public int updateReview(Review review){
        return reviewsDao.updateReview(review);
    }
}
