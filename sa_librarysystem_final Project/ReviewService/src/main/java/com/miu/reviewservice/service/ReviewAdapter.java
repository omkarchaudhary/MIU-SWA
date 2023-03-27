package com.miu.reviewservice.service;

import com.miu.reviewservice.domain.Review;

public class ReviewAdapter {
    public static Review getReviewFromDTO(ReviewDTO reviewDTO){
        return  new Review(reviewDTO.getIsbn(),
                reviewDTO.getRating(),
                reviewDTO.getCustomerName(),
                reviewDTO.getDescription());
    }

    public static ReviewDTO getReviewFromDTO(Review review){
        return  new ReviewDTO(review.getIsbn(),
                review.getRating(),
                review.getCustomerName(),
                review.getDescription());
    }
}
