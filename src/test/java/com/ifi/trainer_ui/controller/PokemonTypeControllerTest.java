package com.ifi.trainer_ui.controller;
import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;
import com.ifi.trainer_ui.pokemonTypes.service.PokemonTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PokemonTypeControllerTest {
    @Test
    void controllerShouldBeAnnotated(){
        assertNotNull(PokemonTypeController.class.getAnnotation(Controller.class));
    }

    @Test
    void pokemons_shouldReturnAModelAndView() {
        var pokemonTypeService = mock(PokemonTypeService.class);

        when(pokemonTypeService.listPokemonsTypes()).thenReturn(List.of(new PokemonType(), new PokemonType()));

        var pokemonTypeController = new PokemonTypeController();
        pokemonTypeController.setPokemonTypeService(pokemonTypeService);
        var modelAndView = pokemonTypeController.pokedex();

        assertEquals("pokedex", modelAndView.getViewName());
        var pokemons = (List<PokemonType>)modelAndView.getModel().get("pokemonTypes");
        assertEquals(2, pokemons.size());
        verify(pokemonTypeService).listPokemonsTypes();
    }

    @Test
    void pokemons_shouldBeAnnotated() throws NoSuchMethodException {
        var pokemonsMethod = PokemonTypeController.class.getDeclaredMethod("pokedex");
        var getMapping = pokemonsMethod.getAnnotation(GetMapping.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/pokedex"}, getMapping.value());
    }

    @Test
    void pokemons_type_shouldReturnAModelAndView() {
        var pokemonTypeService = mock(PokemonTypeService.class);

        String types = "bug,poison";
        when(pokemonTypeService.findAllPokemonByType(types)).thenReturn(List.of(new PokemonType(), new PokemonType(), new PokemonType()));

        var pokemonTypeController = new PokemonTypeController();
        pokemonTypeController.setPokemonTypeService(pokemonTypeService);
        var modelAndView = pokemonTypeController.getAllPokemonTypesByType(types);

        assertEquals("pokedex", modelAndView.getViewName());
        var pokemons = (List<PokemonType>)modelAndView.getModel().get("pokemonTypes");
        assertEquals(3, pokemons.size());
        verify(pokemonTypeService).findAllPokemonByType(types);
    }

    @Test
    void pokemons_type_shouldBeAnnotated() throws NoSuchMethodException {
        var pokemonsMethod = PokemonTypeController.class.getDeclaredMethod("getAllPokemonTypesByType", String.class);
        var requestMapping = pokemonsMethod.getAnnotation(RequestMapping.class);

        assertNotNull(requestMapping);
        assertArrayEquals(new String[]{"/pokedex"}, requestMapping.value());
        assertArrayEquals(new String[]{"types"}, requestMapping.params());
    }


}