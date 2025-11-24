package com.yusufcandmrz.config;

import com.yusufcandmrz.model.User;
import com.yusufcandmrz.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public UserService userService() {
        UserService userService = new UserService();

        List<User> userList = new ArrayList<>();
        userList.add(new User(1L, "Yusuf"));
        userList.add(new User(2L, "Taha"));

        userService.setUserList(userList);

        return userService;
    }
}
