package com.miu.bookqueriesservicetwo.service;

import com.miu.bookqueriesservicetwo.domain.BookQuery;

public class BookQueryAdapter {
    public static BookQuery getBookQueryFromDTO(BookQueryDTO bookQueryDTO){
        return new BookQuery(bookQueryDTO.getIsbn(),
                bookQueryDTO.getTitle(),
                bookQueryDTO.getDescription(),
                bookQueryDTO.getAuthorName(),
                bookQueryDTO.getReviewQueryList());
    }

    public static BookQueryDTO getDTOFromBookQuery(BookQuery bookQuery){
        return new BookQueryDTO(bookQuery.getIsbn(),
                bookQuery.getTitle(),
                bookQuery.getDescription(),
                bookQuery.getAuthorName(),
                bookQuery.getReviewQueryList());
    }
}
