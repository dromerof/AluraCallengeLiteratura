package com.alura.callenge.literatura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "authors")
public class  Autor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "birth_year")
    private Integer fechaDeNacimiento;

    @Column(name = "death_year")
    private Integer fechaDeMuerte;

    private String nombre;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getfechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setfechaDeNacimiento(Integer fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Integer getfechaDeMuerte() {
        return fechaDeMuerte;
    }

    public void setfechaDeMuerte(Integer fechaDeMuerte) {
        this.fechaDeMuerte = fechaDeMuerte;
    }

    public String getName() {
        return nombre;
    }

    public void setName(String name) {
        this.nombre = name;
    }

    public List<Libro> getLibros() {
        return libros;
    }


    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }



    @Override
    public String toString() {
        return "Nombre: " + nombre + '\n' +
                "Fecha de nacimiento: " + fechaDeNacimiento + '\n' +
                "Fecha de muerte: " + fechaDeMuerte + '\n' +
                "Libros: " + libros.stream().map(Libro::getTitle).collect(Collectors.joining(" - ")) + '\n';
    }
}