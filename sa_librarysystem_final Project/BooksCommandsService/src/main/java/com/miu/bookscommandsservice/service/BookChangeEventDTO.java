package com.miu.bookscommandsservice.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookChangeEventDTO {
    private String changeEvent;
    private BookDTO bookDTO;
}
