package com.miu.customerservice.controller;

import com.miu.customerservice.domain.Customer;
import com.miu.customerservice.service.CustomerDTO;
import com.miu.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/{customerNbr}")
    public ResponseEntity<Customer> get(@PathVariable String customerNbr){
        Customer customer = customerService.getCustomer(customerNbr);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return  new ResponseEntity<>(customerDTO,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerDTO);
        return  new ResponseEntity<>(customerDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{customerNbr}")
    public ResponseEntity<String> delete(@PathVariable String customerNbr){
        String customerNumber = customerService.deleteCustomer(customerNbr);
        return new ResponseEntity<>(customerNumber, HttpStatus.OK);
    }
}
