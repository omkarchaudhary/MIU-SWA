package com.miu.bookscommandsservice.service;

import com.miu.bookscommandsservice.domain.Book;
import com.miu.bookscommandsservice.integration.KafkaSender;
import com.miu.bookscommandsservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    KafkaSender kafkaSender;

    public Book getBook(String isbn){
        return bookRepository.findById(isbn).get();
    }

    public void saveBook(BookDTO bookDTO){
        if(bookDTO != null){
            Book book = BookAdapter.getBookFromDTO(bookDTO);
            bookRepository.save(book);
            System.out.println("The title of book service => "+ book.getTitle());
            kafkaSender.sendBookChange(new BookChangeEventDTO("save",bookDTO));
        }
    }

    public void updateBook(BookDTO bookDTO){
        Optional<Book> bookData = bookRepository.findById(bookDTO.getIsbn());
        if(bookData.isPresent()){
            Book book = BookAdapter.getBookFromDTO(bookDTO);
            bookRepository.save(book);
            kafkaSender.sendBookChange(new BookChangeEventDTO("update",bookDTO));
        }
    }
    public String deleteBook(String isbn){
        Optional<Book> book = bookRepository.findById(isbn);
        if(book.isPresent()){
            bookRepository.delete(book.get());
            kafkaSender.sendBookChange(new BookChangeEventDTO("delete",BookAdapter.getDTOFromBook(book.get())));
            return isbn;
        }
        return  null;
    }
}
