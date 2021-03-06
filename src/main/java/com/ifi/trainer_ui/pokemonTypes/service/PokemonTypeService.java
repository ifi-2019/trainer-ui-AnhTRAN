package com.ifi.trainer_ui.pokemonTypes.service;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;
import com.ifi.trainer_ui.pokemonTypes.bo.PokemonTypeLevel;
import com.ifi.trainer_ui.pokemonTypes.bo.Trainer;

import java.util.List;

public interface PokemonTypeService {

    List<PokemonType> listPokemonsTypes();

    List<PokemonType> findAllPokemonByType(String type);

    List<PokemonType> listPokemonsTypesByTrainer(Trainer trainer);

    List<PokemonTypeLevel> listPokemonsTypesLevelByTrainer(Trainer trainer) ;
}