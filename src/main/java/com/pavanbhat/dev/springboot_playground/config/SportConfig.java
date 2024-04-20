package com.pavanbhat.dev.springboot_playground.config;


import com.pavanbhat.dev.springboot_playground.classes.SwimCoach;
import com.pavanbhat.dev.springboot_playground.interfaces.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
