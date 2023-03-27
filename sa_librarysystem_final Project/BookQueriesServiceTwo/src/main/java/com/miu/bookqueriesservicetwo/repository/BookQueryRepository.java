package com.miu.bookqueriesservicetwo.repository;

import com.miu.bookqueriesservicetwo.domain.BookQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookQueryRepository extends MongoRepository<BookQuery,String> {
}
