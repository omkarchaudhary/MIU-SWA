package com.miu.bookqueriesservice.repository;

import com.miu.bookqueriesservice.domain.BookQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookQueryRepository extends MongoRepository<BookQuery,String> {
}
