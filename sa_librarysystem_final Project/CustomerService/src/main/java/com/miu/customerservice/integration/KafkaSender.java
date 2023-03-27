package com.miu.customerservice.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.customerservice.service.CustomerChangeEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendCustomerChange(CustomerChangeEventDTO customerChangeEventDTO){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String customerChangeEventDTOString = objectMapper.writeValueAsString(customerChangeEventDTO);
            kafkaTemplate.send("customerTopic",customerChangeEventDTOString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
