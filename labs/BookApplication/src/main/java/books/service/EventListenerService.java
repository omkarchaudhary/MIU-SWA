package books.service;

import books.integration.AddBookEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EventListenerService {
    @EventListener
    public void onEventListen(AddBookEvent bookEvent){
        System.out.println("Recieved Event :"+ bookEvent.getMessage());
    }
}
