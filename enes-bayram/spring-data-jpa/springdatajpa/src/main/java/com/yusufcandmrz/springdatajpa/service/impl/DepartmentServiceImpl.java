package com.yusufcandmrz.springdatajpa.service.impl;

import com.yusufcandmrz.springdatajpa.dto.DepartmentDto;
import com.yusufcandmrz.springdatajpa.entity.Department;
import com.yusufcandmrz.springdatajpa.repository.DepartmentRepository;
import com.yusufcandmrz.springdatajpa.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void createDepartment(DepartmentDto departmentDto) {
        Department department = new Department();
        BeanUtils.copyProperties(departmentDto, department);
        departmentRepository.save(department);
    }

    @Override
    public DepartmentDto getDepartmentById(Integer id) {
        DepartmentDto departmentDto = new DepartmentDto();
        BeanUtils.copyProperties(findDepartmentById(id), departmentDto);
        return departmentDto;
    }

    private Department findDepartmentById(Integer id) {
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
    }
}
