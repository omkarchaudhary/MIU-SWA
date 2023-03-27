package com.miu.reviewservice.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewChangeEventDTO {
    private ReviewDTO reviewDTO;
}
