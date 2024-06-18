package com.pavanbhat.thymeleafdemo.controller;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    //controller method to show initial HTML form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld-process";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();

        String result = "Yo " + theName;

        model.addAttribute("message", result);

        return "helloworld-process";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model){

        theName = theName.toUpperCase();

        String result = "Hey my friend from v3! " + theName;

        model.addAttribute("message", result);

        return "helloworld-process";
    }
}
