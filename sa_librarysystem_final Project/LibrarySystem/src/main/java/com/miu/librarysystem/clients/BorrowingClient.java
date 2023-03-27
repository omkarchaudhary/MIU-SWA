package com.miu.librarysystem.clients;

import com.miu.librarysystem.dtos.BorrowingDTO;
import com.miu.librarysystem.dtos.BorrowingRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(contextId = "borrowingClient", name = "APIGATEWAY-SERVICE")
public interface BorrowingClient {
    @PostMapping("/borrowing")
    public void saveBorrowing(@RequestBody BorrowingRequestDTO borrowingRequestDTO);

    @GetMapping("/borrowing/{borrowNbr}")
    public BorrowingDTO getBorrowing(@PathVariable String borrowNbr);
}
