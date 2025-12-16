package com.yusufcandmrz.springdatajpa.controller;

import com.yusufcandmrz.springdatajpa.dto.DepartmentDto;

public interface DepartmentController {

    public void createDepartment(DepartmentDto departmentDto);

    public DepartmentDto getDepartmentById(Integer id);
}
