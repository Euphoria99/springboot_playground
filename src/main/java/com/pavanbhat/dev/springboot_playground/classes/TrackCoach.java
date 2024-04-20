package com.pavanbhat.dev.springboot_playground.classes;

import com.pavanbhat.dev.springboot_playground.interfaces.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;


@Component
public class TrackCoach implements Coach {

    public TrackCoach(){
        System.out.println("In Constructor " + getClass().getSimpleName());
    }

    //define init method
    @PostConstruct
    public void doMyStartupStuffs(){
        System.out.println("In the doMyStartupStuffs: " + getClass().getSimpleName());
    }
    @PreDestroy
    public void doMyCleanupStuffs(){
        System.out.println("In the doMyCleanupStuffs: " + getClass().getSimpleName());
    }

    //define our destroy method

    @Override
    public String getDailyPractice(){
        return "Take 10 laps of running";
    }
}