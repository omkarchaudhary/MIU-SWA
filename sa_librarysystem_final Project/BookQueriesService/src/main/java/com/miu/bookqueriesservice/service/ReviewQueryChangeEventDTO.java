package com.miu.bookqueriesservice.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewQueryChangeEventDTO {
    private ReviewDTO reviewDTO;
}
