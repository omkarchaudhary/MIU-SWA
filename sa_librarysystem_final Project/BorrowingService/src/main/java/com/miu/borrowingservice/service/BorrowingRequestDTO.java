package com.miu.borrowingservice.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingRequestDTO {
    private String borrowingNumber;
    private String customerNumber;
    private String isbn;
}
