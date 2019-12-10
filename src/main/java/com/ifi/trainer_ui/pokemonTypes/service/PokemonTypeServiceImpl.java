package com.ifi.trainer_ui.pokemonTypes.service;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonLevel;
import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;
import com.ifi.trainer_ui.pokemonTypes.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    private RestTemplate restTemplate;

    private String pokemonServiceUrl;

    @Override
    public List<PokemonType> listPokemonsTypes() {
        var result = restTemplate.getForObject(pokemonServiceUrl+"/pokemon-types/", PokemonType[].class);
        return Arrays.asList(result);
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${pokemonType.service.url}")
    public void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl ;
    }

    @Override
    public List<PokemonType> findAllPokemonByType(String type) {
        var result = restTemplate.getForObject(pokemonServiceUrl+"/pokemon-types/?types=" + type, PokemonType[].class);
        return Arrays.asList(result);
    }

    @Override
    public List<PokemonType> listPokemonsTypesByTrainer(Trainer trainer) {
        List<PokemonType> result = new ArrayList<>();
        for (PokemonLevel pl : trainer.getTeam())
            result.add(restTemplate.getForObject(pokemonServiceUrl+"/pokemon-types/" + pl.getPokemonType(), PokemonType.class));
        return result;
    }
}