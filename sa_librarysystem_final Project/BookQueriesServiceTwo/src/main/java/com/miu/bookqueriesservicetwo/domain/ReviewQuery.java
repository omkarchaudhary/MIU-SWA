package com.miu.bookqueriesservicetwo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class ReviewQuery {
    @Id
    private String isbn;
    private int rating;
    private String customerName;
    private String description;
}
