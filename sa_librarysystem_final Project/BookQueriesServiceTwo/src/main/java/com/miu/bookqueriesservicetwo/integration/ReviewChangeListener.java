package com.miu.bookqueriesservicetwo.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.bookqueriesservicetwo.service.BookQueryService;
import com.miu.bookqueriesservicetwo.service.ReviewQueryChangeEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReviewChangeListener {
    @Autowired
    private BookQueryService bookQueryService;

    @KafkaListener(topics = "reviewTopic")
    public void receiveReviewChangeEvent(final String reviewChangeEventDTOString) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ReviewQueryChangeEventDTO reviewQueryChangeEventDTO = objectMapper.readValue(reviewChangeEventDTOString, ReviewQueryChangeEventDTO.class);
            bookQueryService.handleReviewChangeEvent(reviewQueryChangeEventDTO);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        };
    }
}
