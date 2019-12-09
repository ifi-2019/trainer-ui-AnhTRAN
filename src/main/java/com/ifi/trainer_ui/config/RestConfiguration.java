package com.ifi.trainer_ui.config;

import com.ifi.trainer_ui.pokemonTypes.bo.Trainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration extends WebSecurityConfigurerAdapter {
    private RestTemplate restTemplate;

    @Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;

    @Bean
    public RestTemplate restTemplate(){
        if (restTemplate == null)
            restTemplate = new RestTemplate();
        return restTemplate;
    }

    @Bean
    public RestTemplate trainerApiRestTemplate() {
        restTemplate().getInterceptors().add(new BasicAuthenticationInterceptor(username, password));
        this.restTemplate.getForEntity("https://trainer-api-atr.herokuapp.com/trainers/Ash", Trainer.class);
        return this.restTemplate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}