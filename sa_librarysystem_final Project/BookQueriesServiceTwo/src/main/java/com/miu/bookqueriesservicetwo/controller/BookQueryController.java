package com.miu.bookqueriesservicetwo.controller;

import com.miu.bookqueriesservicetwo.domain.BookQuery;
import com.miu.bookqueriesservicetwo.service.BookQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RefreshScope
public class BookQueryController {
    @Autowired
    BookQueryService bookQueryService;

    @GetMapping("/bookquery")
    public ResponseEntity<?> getBooks(){
        List<BookQuery> bookQueryList = bookQueryService.getBookQuery();
        return new ResponseEntity<>(bookQueryList, HttpStatus.OK);
    }
    @GetMapping("/bookquery/{isbn}")
    public ResponseEntity<?> getBookByISBN(@PathVariable String isbn){
        BookQuery bookQuery = bookQueryService.getBookQueryBYISBN(isbn);
        return new ResponseEntity<>(bookQuery, HttpStatus.OK);
    }
}
