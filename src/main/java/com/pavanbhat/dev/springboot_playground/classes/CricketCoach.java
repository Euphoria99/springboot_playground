package com.pavanbhat.dev.springboot_playground.classes;

import com.pavanbhat.dev.springboot_playground.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In Constructor " + getClass().getSimpleName());
    }
    @Override
    public String getDailyPractice(){
        System.out.println("In Constructor " + getClass().getSimpleName());
        return "Practice batting for 15 minutes :-)!!";
    }
}
