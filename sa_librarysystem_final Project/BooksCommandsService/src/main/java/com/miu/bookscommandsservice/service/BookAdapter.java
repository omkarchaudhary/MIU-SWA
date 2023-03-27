package com.miu.bookscommandsservice.service;

import com.miu.bookscommandsservice.domain.Book;

public class BookAdapter {
    public static Book getBookFromDTO(BookDTO bookDTO){
        return  new Book(bookDTO.getIsbn(),
                bookDTO.getTitle(),
                bookDTO.getDescription(),
                bookDTO.getAuthorName());
    }

    public static BookDTO getDTOFromBook(Book book){
        return new BookDTO(book.getIsbn(),
                book.getTitle(),
                book.getDescription(),
                book.getAuthorName());
    }
}
