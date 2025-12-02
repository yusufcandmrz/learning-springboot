package com.yusufcandmrz.repository;

import com.yusufcandmrz.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository {

    @Autowired
    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }

    public Optional<Employee> getEmployeeById(String id) {
        return this.employeeList.stream().filter(employee -> employee.getId().equals(id)).findFirst();
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

    public void deleteEmployee(Employee employee) {
        this.employeeList.remove(employee);
    }
}
