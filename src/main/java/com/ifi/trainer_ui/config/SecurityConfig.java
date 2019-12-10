package com.ifi.trainer_ui.config;

import com.ifi.trainer_ui.pokemonTypes.bo.Trainer;
import com.ifi.trainer_ui.pokemonTypes.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@Order(2)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private TrainerService trainerService;

    @Autowired
    public void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImp();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin()
                .and()
                .logout()
                    .permitAll()
                    .logoutSuccessUrl("/login")
                .and()
                .csrf().disable();
    }

    public class UserDetailsServiceImp implements UserDetailsService {
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            Trainer trainer = trainerService.getTrainer(username);

            User.UserBuilder builder = null;
            if (trainer != null) {
                builder = org.springframework.security.core.userdetails.User.withUsername(trainer.getName());
                builder.password(trainer.getPassword());
                builder.roles("USER");
            } else {
                throw new BadCredentialsException("No such user");
            }

            return builder.build();
        }
    }

}
