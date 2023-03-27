package com.miu.customerservice.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerChangeEventDTO {
    public CustomerDTO customerDTO;
}
