package com.miu.borrowingservice.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.borrowingservice.service.BookChangeEventDTO;
import com.miu.borrowingservice.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BookChangeListener {
    @Autowired
    private BorrowingService borrowingService;

    @KafkaListener(topics = "bTopic")
    public void receiveBookChangeEvent(final String bookChangeEventDTOString) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            BookChangeEventDTO bookChangeEventDTO = objectMapper.readValue(bookChangeEventDTOString, BookChangeEventDTO.class);
            borrowingService.handleBookChangeEvent(bookChangeEventDTO);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        };
    }
}
