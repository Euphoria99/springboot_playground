package com.pavanbhat.dev.springboot_playground.classes;

import com.pavanbhat.dev.springboot_playground.interfaces.Coach;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component
@Lazy
public class TennisCoach implements  Coach{

    public TennisCoach(){
        System.out.println("In Constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyPractice(){
        return "Practice your backhand volley";
    }
}