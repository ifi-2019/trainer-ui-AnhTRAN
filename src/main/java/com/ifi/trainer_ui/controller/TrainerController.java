package com.ifi.trainer_ui.controller;

import com.ifi.trainer_ui.pokemonTypes.bo.Trainer;
import com.ifi.trainer_ui.pokemonTypes.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrainerController {

    @Autowired
    private final TrainerService trainerService;

    TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    @GetMapping("/trainers")
    ModelAndView getAllTrainers(){
        return new ModelAndView("trainers", "trainers", trainerService.getAllTrainers());
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
}
