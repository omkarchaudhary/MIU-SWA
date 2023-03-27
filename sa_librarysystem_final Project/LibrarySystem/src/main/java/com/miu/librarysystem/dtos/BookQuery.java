package com.miu.librarysystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookQuery {
    private String isbn;
    private String title;
    private String description;
    private String authorName;
    private List<ReviewQuery> reviewQueryList;
}
