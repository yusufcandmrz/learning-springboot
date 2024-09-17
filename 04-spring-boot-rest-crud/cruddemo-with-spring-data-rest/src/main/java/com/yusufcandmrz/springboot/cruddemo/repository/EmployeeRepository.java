package com.yusufcandmrz.springboot.cruddemo.repository;

import com.yusufcandmrz.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
