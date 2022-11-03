package books.service;

import books.entity.Book;
import books.integration.AddBookEvent;
import books.integration.BookMessagingService;
import books.repository.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    BookMessagingService bookMessagingService;
    @Autowired
    private ApplicationEventPublisher publisher;

    public Book addBook(Book book){
        if(book != null){
            try {
                bookMessagingService.sendMessage(book);
                publisher.publishEvent(new AddBookEvent("Book Added " + book.toString()));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            return bookRepository.save(book);
        }
        return null;
    }
    public Book updateBook(Book book){
        Book newBook = bookRepository.findBookByIsbn(book.getIsbn());
        newBook.setIsbn(book.getIsbn());
        newBook.setAuthor(book.getAuthor());
        newBook.setTitle(book.getTitle());
        newBook.setPrice(book.getPrice());
        try {
            bookMessagingService.sendMessage(book);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return bookRepository.save(newBook);
    }

    public Long deleteBook(String isbn){
        Book book = bookRepository.findBookByIsbn(isbn);
        Long bookId = book.getId();
        if(bookId != null)
        {
            bookRepository.deleteById(bookId);
        }
        try {
            bookMessagingService.sendMessage(book);
            publisher.publishEvent(new AddBookEvent("Book deleted " + book.toString()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return bookId;
    }
    public Book getBook(String isbn){
        return bookRepository.findBookByIsbn(isbn);
    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
