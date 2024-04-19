package com.eren.springcoredemo.rest;

import com.eren.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach coach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach coach,
                          @Qualifier("trackCoach") Coach anotherCoach){
            System.out.println("In constructor : " + getClass().getSimpleName());
            this.coach = coach;
            this.anotherCoach = anotherCoach;
    }
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return coach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans : coach == anotherCoach, " + (coach == anotherCoach);
    }


}
