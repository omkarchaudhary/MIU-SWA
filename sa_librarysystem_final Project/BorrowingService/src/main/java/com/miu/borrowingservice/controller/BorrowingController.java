package com.miu.borrowingservice.controller;

import com.miu.borrowingservice.domain.Borrowing;
import com.miu.borrowingservice.service.BorrowingDTO;
import com.miu.borrowingservice.service.BorrowingRequestDTO;
import com.miu.borrowingservice.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
@RequestMapping("/borrowing")
public class BorrowingController {
    @Autowired
    BorrowingService borrowingService;

    @GetMapping("/{borrowNbr}")
    public ResponseEntity<Borrowing> get(@PathVariable String borrowNbr){
        Borrowing borrowing = borrowingService.getBorrowing(borrowNbr);
        return new ResponseEntity<>(borrowing, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody BorrowingRequestDTO borrowingRequestDTO){
        borrowingService.saveBorrowing(borrowingRequestDTO);
        return  new ResponseEntity<>(borrowingRequestDTO,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody BorrowingRequestDTO borrowingRequestDTO){
        borrowingService.updateBorrowing(borrowingRequestDTO);
        return  new ResponseEntity<>(borrowingRequestDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{borrowNbr}")
    public ResponseEntity<String> delete(@PathVariable String borrowNbr){
        String borrowingNumber = borrowingService.deleteBorrowing(borrowNbr);
        return new ResponseEntity<>(borrowingNumber, HttpStatus.OK);
    }
}
