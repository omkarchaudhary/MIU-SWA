package com.miu.borrowingservice.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDTO {
    private String customerNumber;
    private String name;
}
