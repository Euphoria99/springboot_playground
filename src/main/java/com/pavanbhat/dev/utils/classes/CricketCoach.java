package com.pavanbhat.dev.utils.classes;

import com.pavanbhat.dev.utils.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyPractice(){
        return "Practice batting for 15 minutes!!";
    }
    @Override
    public String getWorkoutPractice(){
        return "Practice Deadlifts";
    }

}
