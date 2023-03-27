package com.miu.librarysystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingDTO {
    private String borrowingNumber;
    private LocalDate date;
    private String customerNumber;
    private String customerName;
    private String isbn;
    private String bookTitle;
}
