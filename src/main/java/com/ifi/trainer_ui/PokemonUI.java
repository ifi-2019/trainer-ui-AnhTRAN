package com.ifi.trainer_ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PokemonUI {

    public static void main(String... args){
        SpringApplication.run(PokemonUI.class, args);
    }

}
