package com.pokemon.repository;

import com.pokemon.entities.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntrenadorRepository extends JpaRepository<Long, Entrenador> {

    @Query( value = "SELECT * FROM entrenador ORDER BY puntos DESC")
    List<Entrenador> findByOrder();
    Entrenador findByNombre(String nombre);
    @Query( value = "SELECT * FROM entrenador GROUP BY region")
    List<Entrenador> findByRegion(String region);
}
