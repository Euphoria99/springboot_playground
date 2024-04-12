package com.pavanbhat.dev.springboot_playground.rest;

import com.pavanbhat.dev.utils.interfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DailyPracticeController {

    //define a private field for the dependency
    private Coach myCoach;
    @Autowired
    public DailyPracticeController(Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/dailypractice")
    public String getPracticeController(){
        return "To see what you need to do daily, use /cricket or /workout succeeding /dailypractice";
    }
    @GetMapping("/dailypractice/cricket")
    public String getDailyPracticeController(){
        return myCoach.getDailyPractice();
    }

    @GetMapping("/dailypractice/workout")
    public String getDailyWorkoutController(){
        return myCoach.getWorkoutPractice();
    }
}
