package books.integration;

import books.entity.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookMessagingService {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Value(value = "${springjms.queueName}")
    private String queueName;

    public void sendMessage(Book book) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String bookAsString = objectMapper.writeValueAsString(book);
        jmsTemplate.convertAndSend(queueName,bookAsString);
    }
}
