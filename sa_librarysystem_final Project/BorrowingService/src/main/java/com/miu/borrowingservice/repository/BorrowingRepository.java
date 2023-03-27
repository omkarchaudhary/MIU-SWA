package com.miu.borrowingservice.repository;

import com.miu.borrowingservice.domain.Borrowing;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BorrowingRepository extends MongoRepository<Borrowing,String> {
}
