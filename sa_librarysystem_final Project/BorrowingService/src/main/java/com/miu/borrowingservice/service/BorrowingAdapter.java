package com.miu.borrowingservice.service;

import com.miu.borrowingservice.domain.Borrowing;

public class BorrowingAdapter {
    public static Borrowing getBorrowingFromDTO(BorrowingDTO borrowingDTO){
        return  new Borrowing(borrowingDTO.getBorrowingNumber(),
                borrowingDTO.getDate(),
                borrowingDTO.getCustomerNumber(),
                borrowingDTO.getCustomerName(),
                borrowingDTO.getIsbn(),
                borrowingDTO.getBookTitle());
    }

    public static BorrowingDTO getDTOFromBorrowing(Borrowing borrowing){
        return  new BorrowingDTO(borrowing.getBorrowingNumber(),
                borrowing.getDate(),
                borrowing.getCustomerNumber(),
                borrowing.getCustomerName(),
                borrowing.getIsbn(),
                borrowing.getBookTitle());
    }
}
