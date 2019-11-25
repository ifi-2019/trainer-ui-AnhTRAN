package com.ifi.trainer_ui.pokemonTypes.service;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequestMapping("/pokemon-types")
public class PokemonTypeServiceImpl implements PokemonTypeService {

    private RestTemplate restTemplate;

    private String pokemonServiceUrl;

    @RequestMapping("/")
    public List<PokemonType> listPokemonsTypes() {
        PokemonType[] result = restTemplate.getForObject(pokemonServiceUrl+"/pokemon-types/", PokemonType[].class);
        if(result != null) return Arrays.asList(result);
        return null;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${pokemonType.service.url}")
    public void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl ;
    }
}