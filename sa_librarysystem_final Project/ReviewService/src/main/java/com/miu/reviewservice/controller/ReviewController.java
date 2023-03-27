package com.miu.reviewservice.controller;

import com.miu.reviewservice.domain.Review;
import com.miu.reviewservice.service.ReviewDTO;
import com.miu.reviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @GetMapping("/{isbn}")
    public ResponseEntity<Review> get(@PathVariable String isbn){
        Review review = reviewService.getReview(isbn);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ReviewDTO reviewDTO){
        reviewService.saveReview(reviewDTO);
        return  new ResponseEntity<>(reviewDTO,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ReviewDTO reviewDTO){
        reviewService.updateReview(reviewDTO);
        return  new ResponseEntity<>(reviewDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<String> delete(@PathVariable String isbn){
        String reviewNumber = reviewService.deleteReview(isbn);
        return new ResponseEntity<>(reviewNumber, HttpStatus.OK);
    }
}
