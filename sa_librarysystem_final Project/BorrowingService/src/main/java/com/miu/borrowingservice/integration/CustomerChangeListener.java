package com.miu.borrowingservice.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.borrowingservice.service.BookChangeEventDTO;
import com.miu.borrowingservice.service.BorrowingService;
import com.miu.borrowingservice.service.CustomerChangeEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerChangeListener {
    @Autowired
    private BorrowingService borrowingService;

    @KafkaListener(topics = "customerTopic")
    public void receiveCustomerChangeEvent(final String customerChangeEventDTOString) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            CustomerChangeEventDTO customerChangeEventDTO = objectMapper.readValue(customerChangeEventDTOString, CustomerChangeEventDTO.class);
            borrowingService.handleCustomerChangeEvent(customerChangeEventDTO);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        };
    }
}
