package com.yusufcandmrz.springdatajpa.controller.impl;

import com.yusufcandmrz.springdatajpa.controller.StudentController;
import com.yusufcandmrz.springdatajpa.dto.StudentDto;
import com.yusufcandmrz.springdatajpa.dto.StudentDtoIU;
import com.yusufcandmrz.springdatajpa.dto.StudentProfileDto;
import com.yusufcandmrz.springdatajpa.service.StudentService;
import jakarta.validation.Valid;
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
    public void createStudent(@RequestBody @Valid StudentDtoIU studentDtoIU) {
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
    public void updateStudentById(@PathVariable Integer id, @RequestBody @Valid StudentDtoIU studentDtoIU) {
        studentService.updateStudentById(id, studentDtoIU);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
    }

    @Override
    @PostMapping("/{id}/profile")
    public void addStudentProfile(@PathVariable Integer id, @RequestBody @Valid StudentProfileDto studentProfileDto) {
        studentService.addStudentProfile(id, studentProfileDto);
    }

    @Override
    @PostMapping("/{studentId}/course")
    public void addCourse(@PathVariable Integer studentId, @RequestParam Integer courseId) {
        studentService.addCourse(studentId, courseId);
    }
}
