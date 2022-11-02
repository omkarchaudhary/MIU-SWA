package books.service;

import books.entity.Book;
import books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book){
        if(book != null){
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
        return bookRepository.save(newBook);
    }

    public Long deleteBook(String isbn){
        Book book = bookRepository.findBookByIsbn(isbn);
        Long bookId = book.getId();
        if(bookId != null)
        {
            bookRepository.deleteById(bookId);
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
