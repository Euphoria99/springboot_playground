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
    private Coach anotherCoach;

    @Autowired
    public DailyPracticeController(
            @Qualifier("trackCoach") Coach theCoach,
            @Qualifier("trackCoach") Coach theAnotherCoach){
        System.out.println("In Constructor " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }


    @GetMapping("/dailypractice")
    public String getDailyPracticeController(){
        return myCoach.getDailyPractice();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
//        singleton scope: true and prototype scope: false
    }
}