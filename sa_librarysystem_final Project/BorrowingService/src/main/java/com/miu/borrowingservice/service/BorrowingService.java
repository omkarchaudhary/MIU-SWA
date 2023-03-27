package com.miu.borrowingservice.service;

import com.miu.borrowingservice.domain.Borrowing;
import com.miu.borrowingservice.repository.BorrowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Service
public class BorrowingService {
    @Autowired
    BorrowingRepository borrowingRepository;
    @Autowired
    CustomerFeignClient customerFeignClient;
    @Autowired
    BookFeignClient bookFeignClient;

    public Borrowing getBorrowing(String isbn){
        return borrowingRepository.findById(isbn).get();
    }

    public void saveBorrowing(BorrowingRequestDTO borrowingRequestDTO){
        if(borrowingRequestDTO != null){
            BookDTO bookDTO = bookFeignClient.getBookByIsbn(borrowingRequestDTO.getIsbn());
            CustomerDTO customerDTO = customerFeignClient.getCustomerByNbr(borrowingRequestDTO.getCustomerNumber());
            BorrowingDTO borrowingDTO = new BorrowingDTO(
                    borrowingRequestDTO.getBorrowingNumber(),
                    LocalDate.now(),
                    borrowingRequestDTO.getCustomerNumber(),
                    customerDTO.getName(),
                    borrowingRequestDTO.getIsbn(),
                    bookDTO.getTitle()
            );

            Borrowing borrowing = BorrowingAdapter.getBorrowingFromDTO(borrowingDTO);
            borrowingRepository.save(borrowing);
        }
    }

    public void updateBorrowing(BorrowingRequestDTO borrowingRequestDTO){
        Optional<Borrowing> borrowingData = borrowingRepository.findById(borrowingRequestDTO.getIsbn());
        if(borrowingData.isPresent()){
            //Borrowing borrowing = BorrowingAdapter.getBorrowingFromDTO(borrowingDTO);
            Borrowing borrowing = borrowingData.get();
            borrowing.setCustomerNumber(borrowingRequestDTO.getCustomerNumber());
            borrowing.setIsbn(borrowingRequestDTO.getIsbn());
            borrowingRepository.save(borrowing);
        }
    }
    public String deleteBorrowing(String isbn){
        Optional<Borrowing> borrowing = borrowingRepository.findById(isbn);
        if(borrowing.isPresent()){
            borrowingRepository.delete(borrowing.get());
            return isbn;
        }
        return  null;
    }

    public void handleBookChangeEvent(BookChangeEventDTO bookChangeEventDTO){
        if(bookChangeEventDTO.getChangeEvent().equals("update")){
            Optional<Borrowing> borrowing = borrowingRepository.findById(bookChangeEventDTO.bookDTO.getIsbn());
            if(borrowing.isPresent()){
                Borrowing borrowingData = borrowing.get();
                borrowingData.setBookTitle(bookChangeEventDTO.bookDTO.getTitle());
                borrowingRepository.save(borrowingData);
            }
        }
    }
    public void handleCustomerChangeEvent(CustomerChangeEventDTO customerChangeEventDTO){
        Optional<Borrowing> borrowing = borrowingRepository.findById(customerChangeEventDTO.customerDTO.getCustomerNumber());
        if(borrowing.isPresent()){
            Borrowing borrowingData = borrowing.get();
            borrowingData.setCustomerName(customerChangeEventDTO.customerDTO.getName());
            borrowingRepository.save(borrowingData);
        }
    }
}
