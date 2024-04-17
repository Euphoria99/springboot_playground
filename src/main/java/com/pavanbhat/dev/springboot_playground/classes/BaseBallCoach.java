package com.pavanbhat.dev.springboot_playground.classes;

import com.pavanbhat.dev.springboot_playground.interfaces.Coach;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BaseBallCoach implements Coach {

    @Override
    public String getDailyPractice(){
        return "Hit 10 home runs";
    }
}
