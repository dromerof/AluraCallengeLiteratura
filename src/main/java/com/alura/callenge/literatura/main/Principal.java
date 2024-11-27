package com.alura.callenge.literatura.main;

import com.alura.callenge.literatura.dto.LibroDto;
import com.alura.callenge.literatura.dto.LibroVista;
import com.alura.callenge.literatura.model.Autor;
import com.alura.callenge.literatura.model.Datos;
import com.alura.callenge.literatura.model.DatosLibro;
import com.alura.callenge.literatura.model.Libro;
import com.alura.callenge.literatura.repository.AutorRepository;
import com.alura.callenge.literatura.repository.LibroRepository;
import com.alura.callenge.literatura.service.ConsumoAPI;
import com.alura.callenge.literatura.service.ConvierteDatos;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private final Scanner teclado;
    private final ConsumoAPI consumoAPI;
    private final ConvierteDatos convierteDatos;
    private final Dotenv dotenv = Dotenv.load();
    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    public Principal(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.teclado = new Scanner(System.in);
        this.consumoAPI = new ConsumoAPI();
        this.convierteDatos = new ConvierteDatos();
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;

    }

    public void muestraMenu() {
        int option = -1;
        System.out.println("Bienvenido a El Viaje Literario\n");

        while (option != 0) {
            System.out.println("Por favor elige una opción:\n");
            System.out.println("""
                        1 - Búsqueda de libro por titulo.
                        2 - Lista de libros registrados.
                        3 - Lista de autores registrados.
                        4 - Lista de autores vivos en un determinado año.
                        5 - Lista de libros por idioma.
                        0 - salir
                    """);

            option = validaOpcion();

            switch (option) {
                case 1 -> buscarLibroTitulo();
                case 2 -> listaLibros();
                case 3 -> listaAutores();
                case 4 -> autorAno();
                case 5 -> librosLenguaje();
                case 0 -> System.out.println("Saliendo del sistema.");
                default -> System.out.println("Elija una opción válida.");
            }
        }
    }

    private int validaOpcion() {
        int option = -1;
        while (option < 0 || option > 5) {
            try {
                System.out.print("Introduce la opción que deseas: ");
                option = teclado.nextInt();
                teclado.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingresa un número del 0 al 5");
                teclado.nextLine();
            }
        }
        return option;
    }

    private void buscarLibroTitulo() {
        System.out.println("Escribe el nombre del libro que deseas buscar: ");
        String busquedaDeLibro = teclado.nextLine();
        String resultadoLibro = consumoAPI.obtenerDatos(dotenv.get("API_URL") + "search=" + busquedaDeLibro.replace(" ", "+"));
        List<DatosLibro> buscarLibro = convierteDatos.obtenerDatos(resultadoLibro, Datos.class).datos();

        if (buscarLibro.isEmpty()) {
            System.out.println("No se han encontrado libros con este nombre.");
        } else {
            guardarLibro(buscarLibro.get(0));
        }
    }

    private void guardarLibro(DatosLibro datosLibro) {
        Libro guardarLibro = new Libro();
        Autor autor = autorRepository.findByNombreContainsIgnoreCase(datosLibro.autores().get(0).nombre()).orElse(null);

        if (autor == null) {
            autor = new Autor();
            autor.setNombre(datosLibro.autores().get(0).nombre());
            autor.setfechaDeNacimiento(datosLibro.autores().get(0).fechaDeNacimiento());
            autor.setfechaDeMuerte(datosLibro.autores().get(0).fechaDeMuerte());
        }
        if (libroRepository.findByTituloContainsIgnoreCase(datosLibro.titulo()).isPresent()) {
            System.out.println("Este libro ya esta registrado.");
        } else {
            guardarLibro.setTitulo(datosLibro.titulo());
            guardarLibro.setDescargas(datosLibro.descargas());
            guardarLibro.setLenguaje(datosLibro.lenguajes().get(0));
            guardarLibro.setAutor(autor);
            if (autor.getLibros() == null) {
                autor.setLibros(new ArrayList<>());
            }
            autor.getLibros().add(guardarLibro);
            autorRepository.save(autor);
            System.out.println("Libro registrado exitosamente.");

        }

    }

    private void listaLibros() {
        List<LibroVista> libros = libroRepository.findLibros();
        if (libros.isEmpty()) {
            System.out.println("No hay libros para mostrar, lista vacía.");
        } else {
            libros.stream()
                    .map(libro -> new LibroDto(libro.getTitulo(), libro.getDescargas(), libro.getLenguaje(), libro.getAutor()))
                    .forEach(System.out::println);
        }
    }

    private void listaAutores() {
        autorRepository.findAll().forEach(System.out::println);
    }

    private void autorAno() {
        System.out.println("Escribe un año en el que deseas buscar autores vivos: ");
        Integer ano = null;

        while (ano == null) {
            try {
                ano = teclado.nextInt();

                List<Autor> listaDeAutorPorAno = autorRepository.findAutoresWithinYearRange(ano);

                if (listaDeAutorPorAno.isEmpty()) {
                    System.out.println("No se han registrado autores que hayan estado vivos en ese año: " + ano);
                } else {
                    System.out.println("Se han encontrado autores en el año: " + ano + '\n');
                    System.out.println(listaDeAutorPorAno);
                }
            } catch (InputMismatchException e) {
                System.out.println("Escribe un año valido");
                teclado.nextLine();
            }

        }

    }

    private void librosLenguaje() {
        System.out.println("Escribe el idioma por el que quieres filtrar los libros, por ejemplo: es(Español) en(Ingles)");
        String libroPorLenguaje = teclado.nextLine();
        List<Libro> lenguajeLibro = libroRepository.findByLenguajeContainsIgnoreCase(libroPorLenguaje);

        if (lenguajeLibro.isEmpty()) {
            System.out.println("No se ha registrado un libro con este idioma");
        } else {
            System.out.println("Libros filtrados por el idioma: " + libroPorLenguaje + '\n');
            System.out.println(lenguajeLibro);
        }

    }

}