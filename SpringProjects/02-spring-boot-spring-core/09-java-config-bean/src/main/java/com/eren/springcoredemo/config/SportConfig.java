package com.eren.springcoredemo.config;

import com.eren.springcoredemo.common.Coach;
import com.eren.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {


    // bean id defaults to the method name
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
