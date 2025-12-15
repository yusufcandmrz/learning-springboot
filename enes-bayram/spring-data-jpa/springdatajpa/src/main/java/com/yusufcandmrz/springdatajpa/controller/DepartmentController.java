package com.yusufcandmrz.springdatajpa.controller;

import com.yusufcandmrz.springdatajpa.dto.DepartmentDto;
import com.yusufcandmrz.springdatajpa.entity.Department;

public interface DepartmentController {

    public void createDepartment(DepartmentDto departmentDto);

    public Department getDepartmentById(Integer id);
}
