package com.miu.librarysystem;

import com.miu.librarysystem.clients.*;
import com.miu.librarysystem.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableKafka
public class LibrarySystemApplication implements CommandLineRunner {

    @Autowired
    private BookClient bookClient;
    @Autowired
    private BookQueryClient bookQueryClient;
    @Autowired
    private BorrowingClient borrowingClient;
    @Autowired
    private CustomerClient customerClient;
    @Autowired
    private ReviewsClient reviewsClient;

    public static void main(String[] args) {
        SpringApplication.run(LibrarySystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("----------Adding Customer---------");
        Address address = new Address("Burlington Ave","Fairfield","52557");
        CustomerDTO customerDTO = new CustomerDTO("1234","John dere","614234567","john@gmail.com",address);
        customerClient.saveCustomer(customerDTO);
        customerDTO = new CustomerDTO("1235","Jasmine kyota","614234567","jasmine@gmail.com",address);
        customerClient.saveCustomer(customerDTO);

        System.out.println("----------Adding Books---------");
        BookDTO bookDTO = new BookDTO("1234","Software Architecture","SA is design to become a software architect","Afqtar khan");
        bookClient.saveBook(bookDTO);
        bookDTO = new BookDTO("1235","Advance Software Development","ASD is all about design pattern","Mule choptera");
        bookClient.saveBook(bookDTO);

        System.out.println("----------Adding Reviews---------");
        ReviewDTO reviewDTO = new ReviewDTO("1234",4,"Shamsher rab","SA is good for experience developer");
        reviewsClient.saveReview(reviewDTO);
        reviewDTO = new ReviewDTO("1235",3,"Muhammad sen","ASD is good for Java Engineer");
        reviewsClient.saveReview(reviewDTO);

        System.out.println("----------Get All Books---------");
        List<BookQuery> bookQueries = bookQueryClient.getAllBooks();
        for (BookQuery bookQuery : bookQueries){
            System.out.println(bookQuery);
        }

        System.out.println("----------Borrowing Books---------");
        BorrowingRequestDTO borrowingRequestDTO = new BorrowingRequestDTO("1234","1234","1234");
        borrowingClient.saveBorrowing(borrowingRequestDTO);

        System.out.println("----------Change book title---------");
        BookDTO bookDTOUpdate = new BookDTO("1234","Software Architecture Update","SA is design to become a software architect","Afqtar khan");
        bookClient.updateBookTitle(bookDTOUpdate);

        Thread.sleep(5000);

        System.out.println("----------Get book of title changed---------");
        System.out.println(bookQueryClient.getBooksTitle("1234"));

        System.out.println("----------get Borrowing Books of title changed---------");
        System.out.println(borrowingClient.getBorrowing("1234"));
    }
}
