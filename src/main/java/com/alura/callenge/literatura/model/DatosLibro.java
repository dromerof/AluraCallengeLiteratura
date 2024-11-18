package com.alura.callenge.literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosLibro(
        @JsonAlias("Title") String titulo,
        @JsonAlias("authors") String autor,
        @JsonAlias("languages") String idioma,
        @JsonAlias("download_count") Double numeroDeDescargas
) {
}
