package com.yusufcandmrz.main;

import com.yusufcandmrz.config.AppConfig;
import com.yusufcandmrz.model.User;
import com.yusufcandmrz.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        for (User user : userService.getUserList()) {
            System.out.println(user);
        }
    }
}
