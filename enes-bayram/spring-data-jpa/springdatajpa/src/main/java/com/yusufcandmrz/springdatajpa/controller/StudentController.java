package com.yusufcandmrz.springdatajpa.controller;

import com.yusufcandmrz.springdatajpa.dto.StudentDtoIU;
import com.yusufcandmrz.springdatajpa.entity.Student;

import java.util.List;

public interface StudentController {

    public void createStudent(StudentDtoIU studentDtoIU);

    public List<Student> readAllStudents();

    public Student readStudentById(Integer id);

    public void updateStudentById(Integer id, Student student);

    public void deleteStudentById(Integer id);
}
