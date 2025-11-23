package com.yusufcandmrz.springboot.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* @SpringBootApplication(scanBasePackages = {
        "com.yusufcandmrz.springboot.springcoredemo",
        "com.yusufcandmrz.springboot.util"
}) */

@SpringBootApplication
public class SpringcoredemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcoredemoApplication.class, args);
    }

}
