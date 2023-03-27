package com.miu.borrowingservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Borrowing {
    @Id
    private String borrowingNumber;
    private LocalDate date;
    private String customerNumber;
    private String customerName;
    private String isbn;
    private String bookTitle;
}
