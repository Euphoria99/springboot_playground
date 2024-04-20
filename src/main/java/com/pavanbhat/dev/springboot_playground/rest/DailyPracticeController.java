package com.pavanbhat.dev.springboot_playground.rest;

import com.pavanbhat.dev.springboot_playground.interfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DailyPracticeController {

    //define a private field for the dependency
    private Coach myCoach;

    @Autowired
    public DailyPracticeController(@Qualifier("trackCoach") Coach theCoach){
        System.out.println("In Constructor " + getClass().getSimpleName());
        myCoach = theCoach;
    }


    @GetMapping("/dailypractice")
    public String getDailyPracticeController(){
        return myCoach.getDailyPractice();
    }
}