package com.miu.bookqueriesservice.service;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
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
