package com.pavanbhat.dev.springboot_playground.classes;

import com.pavanbhat.dev.springboot_playground.interfaces.Coach;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TrackCoach implements Coach {

    public TrackCoach(){
        System.out.println("In Constructor " + getClass().getSimpleName());
    }
    public String getDailyPractice(){
        return "Take 10 laps of running";
    }
}