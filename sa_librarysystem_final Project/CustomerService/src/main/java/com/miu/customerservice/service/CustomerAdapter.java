package com.miu.customerservice.service;

import com.miu.customerservice.domain.Customer;

public class CustomerAdapter {
    public static Customer getCustomerFromDTO(CustomerDTO customerDTO){
        return new Customer(customerDTO.getCustomerNumber(),
                customerDTO.getName(),
                customerDTO.getPhone(),
                customerDTO.getEmail(),
                customerDTO.getAddress());
    }
    public static CustomerDTO getDTOFromCustomer(Customer customer){
        return new CustomerDTO(customer.getCustomerNumber(),
                customer.getName(),
                customer.getPhone(),
                customer.getEmail(),
                customer.getAddress());
    }
}
