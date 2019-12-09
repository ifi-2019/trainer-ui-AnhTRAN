package com.ifi.trainer_ui.controller;

import com.ifi.trainer_ui.pokemonTypes.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PokemonTypeController {
    @Autowired
    private PokemonTypeService pokemonTypeService;

    @GetMapping("/pokedex")
    public ModelAndView pokedex(){
        return new ModelAndView("pokedex", "pokemonTypes", pokemonTypeService.listPokemonsTypes());
    }

    @RequestMapping(value = "/pokedex", params = "types")
    public ModelAndView getAllPokemonTypesByType(@RequestParam String types) {
        return new ModelAndView("pokedex", "pokemonTypes", pokemonTypeService.findAllPokemonByType(types));
    }

    public void setPokemonTypeService(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }

}
