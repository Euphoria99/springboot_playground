package com.pavanbhat.dev.springboot_playground.classes;

import com.pavanbhat.dev.springboot_playground.interfaces.Coach;

//we will not use @Component here this time
public class SwimCoach implements Coach {

    public SwimCoach(){
        System.out.println("In Constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyPractice(){
        return "Swim for 15 minutes";
    }

}
