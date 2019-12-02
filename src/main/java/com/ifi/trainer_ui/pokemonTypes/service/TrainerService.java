package com.ifi.trainer_ui.pokemonTypes.service;


import com.ifi.trainer_ui.pokemonTypes.bo.Trainer;

public interface TrainerService {

    Iterable<Trainer> getAllTrainers();
    Trainer getTrainer(String name);
    Trainer createTrainer(Trainer trainer);
    Trainer replaceTrainer(String trainerName, Trainer trainer);
    void deleteTrainer(String name);
}