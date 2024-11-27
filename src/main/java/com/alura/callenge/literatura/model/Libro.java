package com.alura.callenge.literatura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    @Column(name = "numero_descargas")
    private Integer descargas;

    private String lenguaje;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor author) {
        this.autor = author;
    }

    @Override
    public String toString() {
        return "---------Libro --------------\n" +
                "Titulo: " + titulo + '\n' +
                "Descargas: " + descargas + '\n' +
                "Lenguaje: " + lenguaje + '\n' +
                "Autor: " + autor.getNombre() + '\n' +
                "------------------------------\n";
    }
}
