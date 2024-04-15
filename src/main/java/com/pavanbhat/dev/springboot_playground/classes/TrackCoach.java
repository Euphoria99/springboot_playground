package com.pavanbhat.dev.springboot_playground.classes;

import com.pavanbhat.dev.springboot_playground.interfaces.Coach;
import org.springframework.stereotype.Component;


@Component
public class TrackCoach implements Coach {
    public String getDailyPractice(){
        return "Take 10 laps of running";
    }
}