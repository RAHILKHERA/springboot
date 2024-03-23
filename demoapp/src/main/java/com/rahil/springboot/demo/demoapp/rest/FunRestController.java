package com.rahil.springboot.demo.demoapp.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return "Hello " + coachName + " (" + teamName + ")";
    }

    // expose a new endpoint

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    // expose a new endpoint for fortune
    @GetMapping("/fortune")
    public String yourDailyFortune() {
        return "Your lucky day!";
    }
}
