package com.eren.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class TrackCoach implements Coach{


    @Override
    public String getDailyWorkout() {
        return "Run a had 5k!";
    }
}
