package com.alura.callenge.literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Persona(
        @JsonAlias("birth_year")
        Integer fechaDeNacimiento,
        @JsonAlias("death_year")
        Integer fechaDeMuerte,
        @JsonAlias("name")
        String nombre
) {
}
