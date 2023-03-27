package com.miu.bookscommandsservice.repository;

import com.miu.bookscommandsservice.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
