package com.yusufcandmrz.springboot.cruddemo.service;

import com.yusufcandmrz.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
