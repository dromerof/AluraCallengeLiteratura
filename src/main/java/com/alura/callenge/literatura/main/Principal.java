package com.alura.callenge.literatura.main;

import com.alura.callenge.literatura.model.Libro;
import com.alura.callenge.literatura.repository.LibroRepository;
import com.alura.callenge.literatura.service.ConsumoAPI;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final Scanner teclado = new Scanner(System.in);
    private final ConsumoAPI consumoApi = new ConsumoAPI();
    private final Dotenv dotenv = Dotenv.load();
    private LibroRepository repository;
    private Optional<Libro> libroBuscado;


    //Metodo para mostrar el menu
    public void muestraMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                     1 - Buscar libro por titulo
                     0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    private  void buscarLibroPorTitulo(){
        System.out.println("Escribe el nombre de la libro que deseas buscar: ");
        var nombreLibro = teclado.nextLine();
        libroBuscado = repository.findByTituloContainsIgnoreCase(nombreLibro);

        if (libroBuscado.isPresent()) {
            System.out.println("La serie buscada es: " + libroBuscado.get());
        } else {
            System.out.println("Serie no encontrada");
        }
    }
}
