package com.alura.callenge.literatura.repository;

import com.alura.callenge.literatura.dto.LibroVista;
import com.alura.callenge.literatura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

    Optional<Libro> findByTituloContainsIgnoreCase(String titulo);

    @Query(value = """
            SELECT  l.titulo as titulo, l.numero_descargas as descargas, l.lenguaje as lenguaje, a.nombre as autor FROM libros l INNER JOIN autores a ON l.autor_id = a.id""", nativeQuery = true)
    List<LibroVista> findLibros();

    List<Libro> findByLenguajeContainsIgnoreCase(String language);

}
