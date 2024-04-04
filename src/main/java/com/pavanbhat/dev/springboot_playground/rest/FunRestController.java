package com.pavanbhat.dev.springboot_playground.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //expose a "/" that returns "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }
    @GetMapping("/devtools")
    public String sayHelloDevTools(){
        return "Hello From Dev Tools";
    }

    //injecting properties
    @Value("${player.name}")
   private String playerName;
    @Value("${player.sport}")
    private String playerSport;

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Player " + playerName + " is playing " + playerSport;
    }
}
