package com.yusufcandmrz.springboot.demo.myspringbootapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + ", Team Name: " + teamName;
    }

    @GetMapping("workout")
    public String getDailyWarkout() {
        return "Run a hard 5k!";
    }

    @GetMapping("fortune")
    public String getDailyFortune() {
        return "Today is your lucky day.";
    }
}
