package com.yusufcandmrz.springboot.cruddemo.rest;

import com.yusufcandmrz.springboot.cruddemo.dao.EmployeeDAO;
import com.yusufcandmrz.springboot.cruddemo.entity.Employee;
import com.yusufcandmrz.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("employee id not found -> " + employee.getId());
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.save(employee);
    }
}
