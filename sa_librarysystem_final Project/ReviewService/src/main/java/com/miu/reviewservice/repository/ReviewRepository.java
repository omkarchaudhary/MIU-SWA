package com.miu.reviewservice.repository;

import com.miu.reviewservice.domain.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review,String> {
}
