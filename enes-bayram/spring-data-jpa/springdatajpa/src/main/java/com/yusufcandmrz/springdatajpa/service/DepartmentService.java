package com.yusufcandmrz.springdatajpa.service;

import com.yusufcandmrz.springdatajpa.dto.DepartmentDto;

public interface DepartmentService {

    public void createDepartment(DepartmentDto departmentDto);

    public DepartmentDto getDepartmentById(Integer id);
}
