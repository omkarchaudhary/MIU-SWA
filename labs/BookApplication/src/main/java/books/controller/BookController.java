package books.controller;

import books.entity.Book;
import books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }

    @PostMapping()
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book newBook = bookService.addBook(book);
        return new ResponseEntity<Book>(newBook, HttpStatus.OK);
    }
    @PutMapping()
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        Book newBook = bookService.updateBook(book);
        return new ResponseEntity<Book>(newBook, HttpStatus.OK);
    }
    @DeleteMapping("/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable String isbn){
        Long deletedBookId = bookService.deleteBook(isbn);
        return new ResponseEntity<>(deletedBookId, HttpStatus.OK);
    }
    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable String isbn){
        Book newBook = bookService.getBook(isbn);
        return new ResponseEntity<Book>(newBook, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<?> getAllBook(){
        List<Book> newBook = bookService.getAllBooks();
        return new ResponseEntity<>(newBook, HttpStatus.OK);
    }
}
