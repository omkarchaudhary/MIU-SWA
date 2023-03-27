package com.miu.bookscommandsservice.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.bookscommandsservice.domain.Book;
import com.miu.bookscommandsservice.service.BookChangeEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendBookChange(BookChangeEventDTO bookChangeEventDTO){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String bookChangeEventDTOString = objectMapper.writeValueAsString(bookChangeEventDTO);
            kafkaTemplate.send("bTopic",bookChangeEventDTOString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
