package com.yusufcandmrz.springdatajpa.controller;

import com.yusufcandmrz.springdatajpa.dto.StudentDto;
import com.yusufcandmrz.springdatajpa.dto.StudentDtoIU;
import com.yusufcandmrz.springdatajpa.dto.StudentProfileDto;

import java.util.List;

public interface StudentController {

    public void createStudent(StudentDtoIU studentDtoIU);

    public List<StudentDto> readAllStudents();

    public StudentDto readStudentById(Integer id);

    public void updateStudentById(Integer id, StudentDtoIU studentDtoIU);

    public void deleteStudentById(Integer id);

    public void addStudentProfile(Integer id, StudentProfileDto studentProfileDto);

    public void addCourse(Integer studentId, Integer courseId);
}
