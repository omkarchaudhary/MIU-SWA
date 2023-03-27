package com.miu.bookqueriesservice.service;

import com.miu.bookqueriesservice.domain.ReviewQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookQueryDTO {
    private String isbn;
    private String title;
    private String description;
    private String authorName;
    private List<ReviewQuery> reviewQueryList;
}
