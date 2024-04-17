package com.pavanbhat.dev.springboot_playground.classes;

import com.pavanbhat.dev.springboot_playground.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach {

    public BaseBallCoach(){
        System.out.println("In Constructor " + getClass().getSimpleName());
    }
    @Override
    public String getDailyPractice(){
        return "Hit 10 home runs";
    }
}
