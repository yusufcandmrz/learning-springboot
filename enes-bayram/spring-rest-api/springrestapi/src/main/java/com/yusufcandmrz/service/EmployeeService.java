package com.yusufcandmrz.service;

import com.yusufcandmrz.entity.Employee;
import com.yusufcandmrz.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private static final AtomicInteger nextEmployeeId = new AtomicInteger(6);

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployeeList() {
        return employeeRepository.getEmployeeList();
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.getEmployeeById(id).orElseThrow(() -> new RuntimeException("No employee found"));
    }

    public void addEmployee(String fullName) {
        String id = String.valueOf(nextEmployeeId.getAndIncrement());
        employeeRepository.addEmployee(new Employee(id, fullName));
    }
}
