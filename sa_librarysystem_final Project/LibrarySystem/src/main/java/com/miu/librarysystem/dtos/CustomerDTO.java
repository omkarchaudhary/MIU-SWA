package com.miu.librarysystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String customerNumber;
    private String name;
    private String phone;
    private String email;
    private Address address;
}
