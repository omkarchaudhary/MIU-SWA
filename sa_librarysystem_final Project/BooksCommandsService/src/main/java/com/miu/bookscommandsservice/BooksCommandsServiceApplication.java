package com.miu.bookscommandsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BooksCommandsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksCommandsServiceApplication.class, args);
    }

}
