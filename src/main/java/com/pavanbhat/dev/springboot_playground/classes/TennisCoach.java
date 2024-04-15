package com.pavanbhat.dev.springboot_playground.classes;

import com.pavanbhat.dev.springboot_playground.interfaces.Coach;
import org.springframework.stereotype.Component;


@Component
public class TennisCoach implements  Coach{
    @Override
    public String getDailyPractice(){
        return "Practice your backhand volley";
    }
}