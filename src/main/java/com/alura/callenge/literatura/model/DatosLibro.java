package com.alura.callenge.literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Libro (
        @JsonAlias("title")
        String title,
        @JsonAlias("authors")
        List<Person> authors,
        @JsonAlias("download_count")
        Integer downloadCount,
        @JsonAlias("languages")
        List<String> languages
){
}
