package com.alura.callenge.literatura.repository;

import com.alura.callenge.literatura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {

    Optional<Autor> findByNombreContainsIgnoreCase(String nombre);

    @Query(value = """
            SELECT * FROM autores WHERE fecha_nacimiento <= :año AND fecha_fallecimiento >= :año
            """, nativeQuery = true)
    List<Autor> findAutoresWithinYearRange(@Param("año") Integer año);

}
