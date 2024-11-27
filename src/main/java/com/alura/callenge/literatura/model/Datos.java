package com.alura.callenge.literatura.model;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Resultado(
        @JsonAlias("results")
        List<DatosLibro> resultado
) {
}
