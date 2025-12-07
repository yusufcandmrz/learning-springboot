package com.yusufcandmrz.springdatajpa.service.impl;

import com.yusufcandmrz.springdatajpa.entity.Student;
import com.yusufcandmrz.springdatajpa.repository.StudentRepository;
import com.yusufcandmrz.springdatajpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> readAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student readStudentById(Integer id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
