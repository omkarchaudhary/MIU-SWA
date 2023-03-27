package com.miu.reviewservice.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.reviewservice.service.ReviewChangeEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendReviewChange(ReviewChangeEventDTO reviewChangeEventDTO){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String reviewChangeEventDTOString = objectMapper.writeValueAsString(reviewChangeEventDTO);
            kafkaTemplate.send("reviewTopic",reviewChangeEventDTOString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
