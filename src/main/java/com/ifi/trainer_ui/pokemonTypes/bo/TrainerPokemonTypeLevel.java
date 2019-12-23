package com.ifi.trainer_ui.pokemonTypes.bo;

import java.util.List;

public class TrainerPokemonTypeLevel {
    private String name;;
    private List<PokemonTypeLevel> pokemonTypeLevels;

    public TrainerPokemonTypeLevel(String name, List<PokemonTypeLevel> ptl) {
        this.name = name;
        this.pokemonTypeLevels = ptl;
    }
}
