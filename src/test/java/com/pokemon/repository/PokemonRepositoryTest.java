package com.pokemon.repository;

import com.pokemon.entities.Pokemon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PokemonRepositoryTest {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Test
    void findByNombre() {
        Pokemon pokemon = pokemonRepository.findByNombre("Pikachu");
        assertEquals(pokemon.getNombre(), "Pikachu");
    }

    @Test
    void findByTipo() {
    }

    @Test
    void findByActivo() {
    }
}