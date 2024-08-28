package com.yusufcandmrz.springboot.springcoredemo.rest;

import com.yusufcandmrz.springboot.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // @Autowired
    private Coach coach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("customSwimCoach") Coach coach /* , @Qualifier("cricketCoach") Coach anotherCoach */) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.coach = coach;
        // this.anotherCoach = anotherCoach;
    }

    /* @Autowired
    public void setCoach(Coach coach) {
        this.coach = coach;
    } */

    @GetMapping("/dailyworkout")
    public String getDailtWorkout() {
        return coach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: coach == aontherCoach, " + (coach == anotherCoach);
    }
}
