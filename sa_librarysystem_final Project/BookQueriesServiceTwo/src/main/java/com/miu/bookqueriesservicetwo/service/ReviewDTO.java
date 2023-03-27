package com.miu.bookqueriesservicetwo.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private String isbn;
    private int rating;
    private String customerName;
    private String description;
}
