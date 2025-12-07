package com.yusufcandmrz.springdatajpa.service;

import com.yusufcandmrz.springdatajpa.entity.Student;

import java.util.List;

public interface StudentService {

    public void createStudent(Student student);

    public List<Student> readAllStudents();
}
