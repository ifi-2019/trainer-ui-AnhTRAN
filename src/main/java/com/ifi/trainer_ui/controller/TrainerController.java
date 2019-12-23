package com.ifi.trainer_ui.controller;

import com.ifi.trainer_ui.pokemonTypes.bo.Trainer;
import com.ifi.trainer_ui.pokemonTypes.bo.TrainerPokemonTypeLevel;
import com.ifi.trainer_ui.pokemonTypes.service.PokemonTypeService;
import com.ifi.trainer_ui.pokemonTypes.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TrainerController {

    @Autowired
    private final TrainerService trainerService;

    @Autowired
    private final PokemonTypeService pokemonTypeService;

    TrainerController(TrainerService trainerService, PokemonTypeService pokemonTypeService){
        this.trainerService = trainerService;
        this.pokemonTypeService = pokemonTypeService;
    }

    @GetMapping("/trainers")
    ModelAndView getAllTrainers(){
        List<TrainerPokemonTypeLevel> trainerPokemonTypeLevels = new ArrayList<>();
        Iterable<Trainer> trainers = trainerService.getAllTrainers();
        for (Trainer trainer : trainers) {
            trainerPokemonTypeLevels.add(new TrainerPokemonTypeLevel(trainer.getName(), pokemonTypeService.listPokemonsTypesLevelByTrainer(trainer)));
        }
        return new ModelAndView("trainers", "trainers", trainerPokemonTypeLevels);
    }

    @GetMapping("/trainers/{name}")
    ModelAndView getTrainer(@PathVariable String name){
        return new ModelAndView("trainer", "trainer", trainerService.getTrainer(name));
    }

    @PostMapping("/trainers")
    Trainer newTrainer(@RequestBody Trainer newTrainer) {
        return trainerService.createTrainer(newTrainer);
    }

    @PutMapping("/trainers/{name}")
    Trainer replaceTrainer(@PathVariable String name, @RequestBody Trainer trainerToReplace) {
        return trainerService.replaceTrainer(name, trainerToReplace);
    }

    @DeleteMapping("/trainers/{name}")
    void deleteTrainer(@PathVariable String name){
        trainerService.deleteTrainer(name);
    }

    @GetMapping("/profile")
    ModelAndView getProfil(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        Trainer trainer = trainerService.getTrainer(user.getUsername());
        Map<String, Object> model = new HashMap<>();
        model.put("info", trainer);
        model.put("pokemon_trainer", pokemonTypeService.listPokemonsTypesByTrainer(trainer));
        return new ModelAndView("profile", "user", model);
    }
}
