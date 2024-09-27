package com.pokemon.repository;

import com.pokemon.entities.Pokemon;
import com.pokemon.entities.enums.Fase;
import com.pokemon.entities.enums.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Pokemon findByNombre(String nombre);
    List<Pokemon> findByTipo(Tipo tipo);
    List<Pokemon> findByActivo(boolean activo);
    @Query(value = "SELECT * FROM pokemon WHERE identificador =:? AND fase =:?" , nativeQuery = true)
    public Pokemon obtainPokemonByIdentificator(Long identificator,int fase);
}
