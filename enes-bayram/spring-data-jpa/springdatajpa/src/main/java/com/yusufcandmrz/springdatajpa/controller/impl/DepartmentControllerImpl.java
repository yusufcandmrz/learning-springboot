package com.yusufcandmrz.springdatajpa.controller.impl;

import com.yusufcandmrz.springdatajpa.controller.DepartmentController;
import com.yusufcandmrz.springdatajpa.dto.DepartmentDto;
import com.yusufcandmrz.springdatajpa.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentControllerImpl implements DepartmentController {

    DepartmentService departmentService;

    public DepartmentControllerImpl(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    @PostMapping
    public void createDepartment(@RequestBody DepartmentDto departmentDto) {
        departmentService.createDepartment(departmentDto);
    }

    @Override
    @GetMapping("/{id}")
    public DepartmentDto getDepartmentById(@PathVariable Integer id) {
        return departmentService.getDepartmentById(id);
    }
}
