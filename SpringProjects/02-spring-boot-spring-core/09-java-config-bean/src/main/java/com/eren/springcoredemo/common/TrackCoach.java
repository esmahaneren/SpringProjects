package com.eren.springcoredemo.common;




import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{

    public TrackCoach(){
        System.out.println("In constructor : " + getClass().getSimpleName());
    }


    @Override
    public String getDailyWorkout() {
        return "Run a had 5k!";
    }
}
