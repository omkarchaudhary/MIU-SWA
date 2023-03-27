package com.miu.customerservice.service;

import com.miu.customerservice.domain.Customer;
import com.miu.customerservice.integration.KafkaSender;
import com.miu.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    KafkaSender kafkaSender;

    public Customer getCustomer(String customerNbr){
        return customerRepository.findById(customerNbr).get();
    }

    public void saveCustomer(CustomerDTO customerDTO){
        if(customerDTO != null){
            Customer customer = CustomerAdapter.getCustomerFromDTO(customerDTO);
            customerRepository.save(customer);
        }
    }

    public void updateCustomer(CustomerDTO customerDTO){
        Optional<Customer> customerData = customerRepository.findById(customerDTO.getCustomerNumber());
        if(customerData.isPresent()){
            Customer customer = CustomerAdapter.getCustomerFromDTO(customerDTO);
            customerRepository.save(customer);
            kafkaSender.sendCustomerChange( new CustomerChangeEventDTO(customerDTO));
        }
    }
    public String deleteCustomer(String customerNbr){
        Optional<Customer> customer = customerRepository.findById(customerNbr);
        if(customer.isPresent()){
            customerRepository.delete(customer.get());
            return customerNbr;
        }
        return  null;
    }
}
