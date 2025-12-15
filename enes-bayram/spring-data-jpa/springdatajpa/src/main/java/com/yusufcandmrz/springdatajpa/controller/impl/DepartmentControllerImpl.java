package com.yusufcandmrz.springdatajpa.controller.impl;

import com.yusufcandmrz.springdatajpa.controller.DepartmentController;
import com.yusufcandmrz.springdatajpa.dto.DepartmentDto;
import com.yusufcandmrz.springdatajpa.entity.Department;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentControllerImpl implements DepartmentController {


    @Override
    @PostMapping
    public void createDepartment(DepartmentDto departmentDto) {
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return null;
    }
}
