package com.yusufcandmrz.springboot.cruddemo.rest;

import com.yusufcandmrz.springboot.cruddemo.dao.EmployeeDAO;
import com.yusufcandmrz.springboot.cruddemo.entity.Employee;
import com.yusufcandmrz.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}
