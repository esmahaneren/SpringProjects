package com.eren.springcoredemo.rest;

import com.eren.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    private Coach coach;

    @Autowired
    public DemoController (Coach coach){
        this.coach = coach;
    }


    @GetMapping("/workout")
    public String getDailyWorkout(){
        return coach.getDailyWorkout();
    }



}
