package com.miu.librarysystem.clients;

import com.miu.librarysystem.dtos.BookQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "APIGATEWAY-SERVICE")
public interface BookQueryClient {
    @GetMapping("/bookquery")
    public List<BookQuery> getAllBooks();
    @GetMapping("/bookquery/{isbn}")
    public BookQuery getBooksTitle(@PathVariable String isbn);
}
