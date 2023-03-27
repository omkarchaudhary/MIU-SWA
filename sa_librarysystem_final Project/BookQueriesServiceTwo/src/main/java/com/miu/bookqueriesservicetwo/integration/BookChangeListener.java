package com.miu.bookqueriesservicetwo.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.bookqueriesservicetwo.service.BookQueryChangeEventDTO;
import com.miu.bookqueriesservicetwo.service.BookQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BookChangeListener {
    @Autowired
    private BookQueryService bookQueryService;

    @KafkaListener(topics = "bTopic")
    public void receiveBookChangeEvent(final String bookChangeEventDTOString) {

        try {
            System.out.println("The book event listener => "+ bookChangeEventDTOString);
            ObjectMapper objectMapper = new ObjectMapper();
            BookQueryChangeEventDTO bookQueryChangeEventDTO = objectMapper.readValue(bookChangeEventDTOString, BookQueryChangeEventDTO.class);
            bookQueryService.handleBookChangeEvent(bookQueryChangeEventDTO);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        };
    }
}
