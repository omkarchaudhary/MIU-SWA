package com.miu.reviewservice.service;

import com.miu.reviewservice.domain.Review;
import com.miu.reviewservice.integration.KafkaSender;
import com.miu.reviewservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    KafkaSender kafkaSender;

    public Review getReview(String isbn){
        return reviewRepository.findById(isbn).get();
    }

    public void saveReview(ReviewDTO reviewDTO){
        if(reviewDTO != null){
            Review review = ReviewAdapter.getReviewFromDTO(reviewDTO);
            reviewRepository.save(review);
            kafkaSender.sendReviewChange(new ReviewChangeEventDTO(reviewDTO));
        }
    }

    public void updateReview(ReviewDTO reviewDTO){
        Optional<Review> reviewData = reviewRepository.findById(reviewDTO.getIsbn());
        if(reviewData.isPresent()){
            Review review = ReviewAdapter.getReviewFromDTO(reviewDTO);
            reviewRepository.save(review);
        }
    }
    public String deleteReview(String isbn){
        Optional<Review> review = reviewRepository.findById(isbn);
        if(review.isPresent()){
            reviewRepository.delete(review.get());
            return isbn;
        }
        return  null;
    }
}
