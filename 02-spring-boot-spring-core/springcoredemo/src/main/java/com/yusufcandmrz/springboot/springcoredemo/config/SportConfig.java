package com.yusufcandmrz.springboot.springcoredemo.config;

import com.yusufcandmrz.springboot.springcoredemo.common.Coach;
import com.yusufcandmrz.springboot.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("customSwimCoach")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
