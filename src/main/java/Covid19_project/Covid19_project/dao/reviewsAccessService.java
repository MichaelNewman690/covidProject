package com.example.covidProject.dao;

import com.example.covidProject.model.Review;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository("postgres")
public class reviewsAccessService implements ReviewsDao{
    private static List<Review> DB = new ArrayList<>();
    @Override
    public int insertReview(Review review) {
        DB.add(review);
        return 1;
    }

    @Override
    public List<Review> selectAllReviews(String country) {
        List<Review> allReviews = DB.stream().filter(r -> r.getCountry().equals(country))
                .collect(Collectors.toList());
        return allReviews;
    }

    @Override
    public int deleteReview(Review oldReview) {
        for(Review review: DB){
            if(oldReview.getId().equals(review.getId())
                    && oldReview.getCountry().equals(review.getCountry())){
                DB.remove(review);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int updateReview(Review newReview) {
        for(Review oldReview: DB){
            if(oldReview.getId().equals(newReview.getId())
                    && oldReview.getCountry().equals(newReview.getCountry())){
                oldReview.setTextbox(newReview.getTextbox());
                return 1;
            }
        }
        System.out.println(0);
        return 0;
    }
}
