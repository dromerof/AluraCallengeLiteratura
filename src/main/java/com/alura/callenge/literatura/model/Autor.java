package com.alura.callenge.literatura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autores")
public class  Autor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "fecha_nacimiento")
    private Integer fechaDeNacimiento;

    @Column(name = "fecha_fallecimiento")
    private Integer fechaDeMuerte;

    private String nombre;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor() {}

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String name) {
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
        return String.format(
                "-------------------AUTOR---------------------\n" +
                "Nombre: %s%n" +
                        "Fecha de nacimiento: %s%n" +
                        "Fecha de muerte: %s%n" +
                        "Libros: %s%n" +
                        "----------------------------------------------\n",
                nombre, fechaDeNacimiento, fechaDeMuerte, libros.stream().map(Libro::getTitulo).collect(Collectors.joining(" - "))
        );
    }
}