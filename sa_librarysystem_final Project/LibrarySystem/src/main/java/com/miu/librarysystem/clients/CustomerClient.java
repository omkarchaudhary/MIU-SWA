package com.miu.librarysystem.clients;

import com.miu.librarysystem.dtos.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(contextId = "customerClient", name = "APIGATEWAY-SERVICE")
public interface CustomerClient {
    @PostMapping("/customer")
    public void saveCustomer(@RequestBody CustomerDTO customerDTO);
}
