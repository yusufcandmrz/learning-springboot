package com.yusufcandmrz.config;

import com.yusufcandmrz.entity.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Employee> employeeList() {
        return List.of(
                new Employee("1", "Yusuf Demiroz"),
                new Employee("2", "Taha Huseyin Demiroz"),
                new Employee("3", "Muhammet Demiroz"),
                new Employee("4", "Sait Demiroz"));
    }
}
