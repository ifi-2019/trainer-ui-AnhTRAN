package com.ifi.trainer_ui.pokemonTypes.bo;

public class PokemonLevel {
    private int idPokemonType;
    private int level;
    private PokemonType type;

    public int getIdPokemonType() {
        return idPokemonType;
    }

    public void setIdPokemonType(int idPokemonType) {
        this.idPokemonType = idPokemonType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public PokemonType getType() {
        return type;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }
}
