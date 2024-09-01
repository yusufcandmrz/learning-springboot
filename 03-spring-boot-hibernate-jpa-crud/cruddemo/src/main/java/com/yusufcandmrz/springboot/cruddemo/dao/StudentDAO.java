package com.yusufcandmrz.springboot.cruddemo.dao;

import com.yusufcandmrz.springboot.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student getById(Integer studentId);

    List<Student> findAll();

    List<Student> findByLastName(String studentLastName);

    void update(Student student);

    void delete(Integer studentId);

    int deleteAll();
}
