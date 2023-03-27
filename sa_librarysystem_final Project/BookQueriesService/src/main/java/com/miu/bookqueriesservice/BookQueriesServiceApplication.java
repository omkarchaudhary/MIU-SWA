package com.miu.bookqueriesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BookQueriesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookQueriesServiceApplication.class, args);
    }

}
