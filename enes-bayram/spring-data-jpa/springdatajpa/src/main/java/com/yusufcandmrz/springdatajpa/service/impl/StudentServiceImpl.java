package com.yusufcandmrz.springdatajpa.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.yusufcandmrz.springdatajpa.dto.StudentDto;
import com.yusufcandmrz.springdatajpa.dto.StudentDtoIU;
import com.yusufcandmrz.springdatajpa.entity.Student;
import com.yusufcandmrz.springdatajpa.repository.StudentRepository;
import com.yusufcandmrz.springdatajpa.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void createStudent(StudentDtoIU studentDtoIU) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDtoIU, student);
        studentRepository.save(student);
    }

    @Override
    public List<StudentDto> readAllStudents() {
        return studentRepository.findAll().stream().map(student -> {
            StudentDto studentDto = new StudentDto();
            BeanUtils.copyProperties(student, studentDto);
            return studentDto;
        }).toList();
    }

    @Override
    public StudentDto readStudentById(Integer id) {
        StudentDto studentDto = new StudentDto();
        Student student = findStudentById(id);
        BeanUtils.copyProperties(student, studentDto);
        return studentDto;
    }

    @Override
    public void updateStudentById(Integer id, Student student) {
        Student dbStudent = findStudentById(id);
        dbStudent.setFullName(student.getFullName());
        dbStudent.setBirthOfDate(student.getBirthOfDate());
        studentRepository.save(dbStudent);
    }

    @Override
    public void deleteStudentById(Integer id) {
        Student dbStudent = findStudentById(id);
        studentRepository.delete(dbStudent);
    }

    private Student findStudentById(Integer id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

}
