package com.miu.librarysystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingRequestDTO {
    private String borrowingNumber;
    private String customerNumber;
    private String isbn;
}
