package com.yusufcandmrz.springdatajpa.controller.impl;

import com.yusufcandmrz.springdatajpa.controller.StudentController;
import com.yusufcandmrz.springdatajpa.dto.StudentDto;
import com.yusufcandmrz.springdatajpa.dto.StudentDtoIU;
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
    public void createStudent(@RequestBody StudentDtoIU studentDtoIU) {
        studentService.createStudent(studentDtoIU);
    }

    @Override
    @GetMapping()
    public List<StudentDto> readAllStudents() {
        return studentService.readAllStudents();
    }

    @Override
    @GetMapping("/{id}")
    public StudentDto readStudentById(@PathVariable Integer id) {
        return studentService.readStudentById(id);
    }

    @Override
    @PutMapping("/{id}")
    public void updateStudentById(@PathVariable Integer id, @RequestBody StudentDtoIU studentDtoIU) {
        studentService.updateStudentById(id, studentDtoIU);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
    }
}
