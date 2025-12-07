package com.yusufcandmrz.springdatajpa.controller;

import com.yusufcandmrz.springdatajpa.entity.Student;

import java.util.List;

public interface StudentController {

    public void createStudent(Student student);

    public List<Student> readAllStudents();

    public Student readStudentById(Integer id);
}
