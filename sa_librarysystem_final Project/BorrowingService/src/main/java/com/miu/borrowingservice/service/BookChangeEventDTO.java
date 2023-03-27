package com.miu.borrowingservice.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookChangeEventDTO {
    public  String changeEvent;
    public BookDTO bookDTO;
}
