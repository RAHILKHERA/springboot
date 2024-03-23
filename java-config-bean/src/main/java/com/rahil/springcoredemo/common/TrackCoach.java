package com.rahil.springcoredemo.common;

//import org.springframework.context.annotation.Lazy;
//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// @Primary
@Component
// @Lazy
public class TrackCoach implements Coach {

    TrackCoach() {
        System.out.println("In Construc: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

}
