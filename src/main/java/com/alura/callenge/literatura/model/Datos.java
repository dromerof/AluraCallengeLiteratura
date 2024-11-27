package com.alura.callenge.literatura.model;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Datos(
        @JsonAlias("results")
        List<DatosLibro> datos
) {
}
