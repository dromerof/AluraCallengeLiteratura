package com.alura.callenge.literatura.dto;

public class LibroDto {
    private String titulo;
    private Integer descargas;
    private String lenguaje;
    private String autor;

    public LibroDto() {
    }

    public LibroDto(String titulo, Integer descargas, String lenguaje, String autor) {
        this.titulo = titulo;
        this.descargas = descargas;
        this.lenguaje = lenguaje;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return String.format(
                "-------------------LIBRO---------------------\n" +
                        "Titulo: %s\n" +
                        "Descargas: %d\n" +
                        "Lenguaje: %s\n" +
                        "Autor: %s\n" +
                        "----------------------------------------------\n",
                titulo, descargas, lenguaje, autor
        );
    }

}