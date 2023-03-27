package com.miu.bookscommandsservice.controller;

import com.miu.bookscommandsservice.domain.Book;
import com.miu.bookscommandsservice.service.BookDTO;
import com.miu.bookscommandsservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> get(@PathVariable String isbn){
        Book book = bookService.getBook(isbn);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody BookDTO bookDTO){
        bookService.saveBook(bookDTO);
        return  new ResponseEntity<>(bookDTO,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody BookDTO bookDTO){
        bookService.updateBook(bookDTO);
        return  new ResponseEntity<>(bookDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<String> delete(@PathVariable String isbn){
        String bookNumber = bookService.deleteBook(isbn);
        return new ResponseEntity<>(bookNumber, HttpStatus.OK);
    }
}
