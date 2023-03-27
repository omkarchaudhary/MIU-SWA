package com.miu.bookqueriesservicetwo.service;

import com.miu.bookqueriesservicetwo.domain.BookQuery;
import com.miu.bookqueriesservicetwo.domain.ReviewQuery;
import com.miu.bookqueriesservicetwo.repository.BookQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookQueryService {
    @Autowired
    private BookQueryRepository bookQueryRepository;

    public List<BookQuery> getBookQuery(){
        return bookQueryRepository.findAll();
    }
    public BookQuery getBookQueryBYISBN( String isbn){
        return bookQueryRepository.findById(isbn).get();
    }
    public void saveBookQuery(BookQueryDTO bookQueryDTO){
        if(bookQueryDTO != null){
            BookQuery bookQuery = BookQueryAdapter.getBookQueryFromDTO(bookQueryDTO);
            bookQueryRepository.save(bookQuery);
        }
    }

    public void updateBookQuery(BookQueryDTO bookQueryDTO){
        Optional<BookQuery> bookQueryData = bookQueryRepository.findById(bookQueryDTO.getIsbn());
        if(bookQueryData.isPresent()){
            BookQuery bookQuery = BookQueryAdapter.getBookQueryFromDTO(bookQueryDTO);
            bookQueryRepository.save(bookQuery);
        }
    }
    public String deleteBookQuery(String isbn){
        Optional<BookQuery> bookQuery = bookQueryRepository.findById(isbn);
        if(bookQuery.isPresent()){
            bookQueryRepository.delete(bookQuery.get());
            return isbn;
        }
        return  null;
    }

    public void handleBookChangeEvent(BookQueryChangeEventDTO bookQueryChangeEventDTO){
        if (bookQueryChangeEventDTO.getChangeEvent().equals("save")){
            saveBookQuery(bookQueryChangeEventDTO.getBookQueryDTO());
        } else if (bookQueryChangeEventDTO.getChangeEvent().equals("delete")){
            deleteBookQuery(bookQueryChangeEventDTO.getBookQueryDTO().getIsbn());
        }
        else if (bookQueryChangeEventDTO.getChangeEvent().equals("update")){
            Optional<BookQuery> optionalBookQuery = bookQueryRepository.findById(bookQueryChangeEventDTO.getBookQueryDTO().getIsbn());
            if(optionalBookQuery.isPresent()){
                BookQueryDTO bookQueryDTO = BookQueryAdapter.getDTOFromBookQuery(optionalBookQuery.get());
                bookQueryDTO.setTitle(bookQueryChangeEventDTO.getBookQueryDTO().getTitle());
                bookQueryDTO.setAuthorName(bookQueryChangeEventDTO.getBookQueryDTO().getAuthorName());
                bookQueryDTO.setDescription(bookQueryChangeEventDTO.getBookQueryDTO().getDescription());
                updateBookQuery(bookQueryDTO);
            }
        }
    }
    public void handleReviewChangeEvent(ReviewQueryChangeEventDTO reviewQueryChangeEventDTO){
        Optional<BookQuery> optionalBookQuery = bookQueryRepository.findById(reviewQueryChangeEventDTO.getReviewDTO().getIsbn());
        if(optionalBookQuery.isPresent()){
            BookQuery bookQuery = optionalBookQuery.get();
            List<ReviewQuery> reviewQueries = new ArrayList<>();
            //get existing reviews
            if(bookQuery.getReviewQueryList() != null){
                bookQuery.getReviewQueryList().forEach((x) -> reviewQueries.add(x));
            }

            ReviewQuery reviewQuery = new ReviewQuery(reviewQueryChangeEventDTO.getReviewDTO().getIsbn(),
                    reviewQueryChangeEventDTO.getReviewDTO().getRating(),
                    reviewQueryChangeEventDTO.getReviewDTO().getCustomerName(),
                    reviewQueryChangeEventDTO.getReviewDTO().getDescription());
            reviewQueries.add(reviewQuery);
            bookQuery.setReviewQueryList(reviewQueries);
            bookQueryRepository.save(bookQuery);
        }
    }
}
