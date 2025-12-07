package com.yusufcandmrz.springdatajpa.controller.impl;

import com.yusufcandmrz.springdatajpa.controller.StudentController;
import com.yusufcandmrz.springdatajpa.entity.Student;
import com.yusufcandmrz.springdatajpa.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentControllerImpl implements StudentController {

    StudentService studentService;

    public StudentControllerImpl(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    @PostMapping()
    public void createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
    }
}
