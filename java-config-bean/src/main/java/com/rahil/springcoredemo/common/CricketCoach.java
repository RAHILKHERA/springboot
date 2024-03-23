package com.rahil.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

    CricketCoach() {
        System.out.println("In Construc: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practie fast bowling for 15 minutes.!!!!";
    }

}
