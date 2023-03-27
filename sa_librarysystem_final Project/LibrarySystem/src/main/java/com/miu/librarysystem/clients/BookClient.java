package com.miu.librarysystem.clients;

import com.miu.librarysystem.dtos.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(contextId = "bookClient", name = "APIGATEWAY-SERVICE")
public interface BookClient {
    @PostMapping ("/book")
    public void saveBook(@RequestBody BookDTO bookDTO);
    @PutMapping("/book")
    public void updateBookTitle(@RequestBody BookDTO bookDTO);

}
