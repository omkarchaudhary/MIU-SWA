package com.miu.bookqueriesservicetwo.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookQueryChangeEventDTO {
    private String changeEvent;

    @JsonProperty(value = "bookDTO")
    private BookQueryDTO bookQueryDTO;
}
