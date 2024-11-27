package com.alura.callenge.literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("title")
        String titulo,
        @JsonAlias("authors")
        List<DatosAutor> autores,
        @JsonAlias("download_count")
        Integer descargas,
        @JsonAlias("languages")
        List<String> lenguajes
){
}
