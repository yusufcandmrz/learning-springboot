package com.yusufcandmrz.repository;

import com.yusufcandmrz.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository {

    private List<Employee> employeeList = new ArrayList<>(List.of(
            new Employee("1", "Yusuf Demiroz"),
            new Employee("2", "Taha Huseyin Demiroz"),
            new Employee("3", "Muhammet Demiroz"),
            new Employee("4", "Sait Demiroz")
    ));

    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }

    public Optional<Employee> getEmployeeById(String id) {
        return this.employeeList.stream().filter(employee -> employee.getId().equals(id)).findFirst();
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

    public void deleteEmployee(String id) {
        employeeList.removeIf(e -> e.getId().equals(id));
    }

    public void updateEmployee(String id, String fullName) {
        Employee employee = getEmployeeById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found: " + id));
        employee.setFullName(fullName);
    }

}
