package com.miu.borrowingservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerFeignClient {
    @GetMapping("customer/{customerNbr}")
    public CustomerDTO getCustomerByNbr(@PathVariable String customerNbr);
}
