package com.rahil.springcoredemo.rest;

import org.springframework.web.bind.annotation.RestController;

import com.rahil.springcoredemo.common.Coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DemoController {

    private Coach myCoach;
    // private Coach anotherCoach;

    // @Autowired
    // DemoController(@Qualifier("cricketCoach") Coach coach,
    // @Qualifier("cricketCoach") Coach anotherCoach) {
    // System.out.println("In Construc: " + getClass().getSimpleName());
    // this.myCoach = coach;
    // this.anotherCoach = anotherCoach;
    // }

    @Autowired
    DemoController(@Qualifier("cricketCoach") Coach coach) {
        System.out.println("In Construc: " + getClass().getSimpleName());
        this.myCoach = coach;
    }
    // @Autowired
    // DemoController(Coach coach) {
    // this.myCoach = coach;
    // }

    public void doSomeStuff(Coach coach) {
        this.myCoach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    // @GetMapping("/check")
    // public String check() {
    // return "Comparing beans: myCoach == anotherCoach, " + (myCoach ==
    // anotherCoach);
    // }

}
