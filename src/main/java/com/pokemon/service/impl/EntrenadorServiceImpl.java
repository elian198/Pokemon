package com.pokemon.service.impl;

import com.pokemon.entities.Entrenador;
import com.pokemon.entities.Item;
import com.pokemon.entities.Pokemon;
import com.pokemon.repository.EntrenadorRepository;
import com.pokemon.repository.PokemonRepository;
import com.pokemon.service.interfaces.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EntrenadorServiceImpl implements EntrenadorService {

    @Autowired private EntrenadorRepository entrenadorRepository;
    @Autowired private PokemonRepository pokemonRepository;


    @Override
    public List<Entrenador> findAll() {
        return entrenadorRepository.findByOrder();
    }

    @Override
    public String deleteByNombre(String nombre) {
        entrenadorRepository.deleteByNombre(nombre);
        return "entrenador eliminado";
    }

    @Override
    public void save(Entrenador entrenador) {
     entrenadorRepository.save(entrenador);
    }

    @Override
    public Entrenador addPounts(Long id, Integer puntos) {
       Optional<Entrenador> entrenador = entrenadorRepository.findById(id);
        if(entrenador.isPresent() ){
            entrenador.get().setPuntos(entrenador.get().getPuntos() + puntos);
            entrenadorRepository.save(entrenador.get());
            return entrenador.get();
        }
        return null;
    }

    @Override
    public Entrenador substracPounts(Long id, Integer puntos) {
        Optional<Entrenador> entrenador = entrenadorRepository.findById(id);
        if(entrenador.isPresent() ){
            entrenador.get().setPuntos(entrenador.get().getPuntos() - puntos);
            entrenadorRepository.save(entrenador.get());
            return entrenador.get();
        }
        return null;
    }

    @Override
    public void addItems(Long id, Item item) {
        Optional<Entrenador> entrenador = entrenadorRepository.findById(id);
        entrenador.ifPresent(value -> value.getItems().add(item));
    }

    @Override
    public void addPokemon(Long id, Pokemon pokemon) {
        Optional<Entrenador> entrenador = entrenadorRepository.findById(id);
        entrenador.ifPresent(value -> value.getPokemones().put(pokemon.getNombre(), pokemon));
    }

    @Override
    public Entrenador evolucionPokemon(Entrenador entrenador, Pokemon pokemon) {
       Pokemon pokemonEvolucionado
               = pokemonRepository.obtainPokemonByIdentificator(pokemon.getIdentificador(),pokemon.getFase().ordinal() + 1);
       entrenador.getPokemones().put(pokemon.getNombre(), pokemonEvolucionado);
       return entrenador;
    }

    public List<Entrenador>  groupByRegion(String region){
        return entrenadorRepository.findByRegion(region);
    }


}
