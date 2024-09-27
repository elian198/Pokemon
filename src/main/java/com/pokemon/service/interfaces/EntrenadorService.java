package com.pokemon.service.interfaces;

import com.pokemon.entities.Entrenador;
import com.pokemon.entities.Item;
import com.pokemon.entities.Pokemon;

import java.util.List;

public interface EntrenadorService {
    List<Entrenador> findAll();
    String deleteByNombre(String nombre);
    void save(Entrenador entrenador);
    Entrenador addPounts(Long id, Integer puntos);
    Entrenador substracPounts(Long id, Integer puntos);
    void addItems(Long id, Item item);
    void addPokemon(Long id, Pokemon pokemon);

   Entrenador evolucionPokemon(Entrenador entrenador, Pokemon pokemon);
}
