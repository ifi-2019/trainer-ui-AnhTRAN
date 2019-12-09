package com.ifi.trainer_ui.pokemonTypes.service;

import com.ifi.trainer_ui.pokemonTypes.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    private RestTemplate restTemplate;

    private String pokemonServiceUrl;

    @Autowired
    @Qualifier("trainerApiRestTemplate")
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${trainer.service.url}")
    public void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl ;
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return Arrays.asList(restTemplate.getForObject(pokemonServiceUrl+"/trainers/", Trainer[].class));
    }

    @Override
    public Trainer getTrainer(String name) {
        return restTemplate.getForObject(pokemonServiceUrl+"/trainers/"+name, Trainer.class);
    }

    @Override
    public Trainer createTrainer(Trainer trainer) {
        //return trainerRepository.save(trainer);
        //TODO
        return null;
    }

    @Override
    public Trainer replaceTrainer(String trainerName, Trainer trainer) {
//        Trainer oldTrainer = trainerRepository.findById(trainerName).orElse(null);
//        if (oldTrainer != null) {
//            oldTrainer.replaceTrainer(trainer);
//            return trainerRepository.save(oldTrainer);
//        }
        //TODO
        return null;
    }

    @Override
    public void deleteTrainer(String name) {
        //TODO
        //trainerRepository.deleteById(name);
    }
}