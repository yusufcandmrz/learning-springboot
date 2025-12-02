package com.yusufcandmrz.controller;

import com.yusufcandmrz.entity.Employee;
import com.yusufcandmrz.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<Employee> getEmployeeList() {
        return employeeService.getEmployeeList();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping()
    public void addEmployee(@RequestParam String fullName) {
        employeeService.addEmployee(fullName);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@RequestParam String id) {
        employeeService.deleteEmployeeById(id);
    }
}
