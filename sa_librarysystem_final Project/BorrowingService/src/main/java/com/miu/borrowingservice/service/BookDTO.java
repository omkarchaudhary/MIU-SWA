package com.miu.borrowingservice.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDTO {
    private String isbn;
    private String title;
}
