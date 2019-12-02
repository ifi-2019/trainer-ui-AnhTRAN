package com.ifi.trainer_ui.pokemonTypes.bo;

import java.util.List;

public class Trainer {
    private String name;

    private List<PokemonLevel> team;

    public Trainer() {
    }

    public Trainer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PokemonLevel> getTeam() {
        return team;
    }

    public void setTeam(List<PokemonLevel> team) {
        this.team = team;
    }

    public Trainer orElse(Object o) {
        if (o instanceof  Trainer) return ((Trainer) o);
        return null;
    }

    public void replaceTrainer(Trainer trainer) {
        this.name = trainer.getName();
        this.team = trainer.getTeam();
    }
}
