package com.alura.callenge.literatura;

import com.alura.callenge.literatura.main.Principal;
import com.alura.callenge.literatura.repository.AutorRepository;
import com.alura.callenge.literatura.repository.LibroRepository;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraturaApplication implements CommandLineRunner {
    @Autowired
    LibroRepository libroRepository;

    @Autowired
    AutorRepository autorRepository;

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
        SpringApplication.run(LiteraturaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal app = new Principal(libroRepository, autorRepository);
        app.muestraMenu();
    }

}

