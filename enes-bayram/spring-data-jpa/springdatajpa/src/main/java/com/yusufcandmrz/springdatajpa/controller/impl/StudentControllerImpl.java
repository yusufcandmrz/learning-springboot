package com.yusufcandmrz.springdatajpa.controller.impl;

import com.yusufcandmrz.springdatajpa.controller.StudentController;
import com.yusufcandmrz.springdatajpa.entity.Student;
import com.yusufcandmrz.springdatajpa.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Override
    @GetMapping()
    public List<Student> readAllStudents() {
        return studentService.readAllStudents();
    }

    @Override
    @GetMapping("/{id}")
    public Student readStudentById(@PathVariable Integer id) {
        return studentService.readStudentById(id);
    }

    @Override
    @PutMapping("/{id}")
    public void updateStudentById(@PathVariable Integer id, @RequestBody Student student) {
        studentService.updateStudentById(id, student);
    }
}
