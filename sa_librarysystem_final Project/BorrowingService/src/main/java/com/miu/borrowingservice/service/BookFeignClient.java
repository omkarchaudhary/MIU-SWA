package com.miu.borrowingservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BOOKCOMMAND-SERVICE")
public interface BookFeignClient {
    @GetMapping("/book/{isbn}")
    public BookDTO getBookByIsbn(@PathVariable String isbn);
}
