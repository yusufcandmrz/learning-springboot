package com.yusufcandmrz.springdatajpa.service.impl;

import com.yusufcandmrz.springdatajpa.dto.StudentDto;
import com.yusufcandmrz.springdatajpa.dto.StudentDtoIU;
import com.yusufcandmrz.springdatajpa.entity.Student;
import com.yusufcandmrz.springdatajpa.repository.StudentRepository;
import com.yusufcandmrz.springdatajpa.service.StudentService;
import org.springframework.beans.BeanUtils;
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
    public void createStudent(StudentDtoIU studentDtoIU) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDtoIU, student);
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

    @Override
    public void updateStudentById(Integer id, Student student) {
        Student dbStudent = readStudentById(id);
        dbStudent.setFullName(student.getFullName());
        dbStudent.setBirthOfDate(student.getBirthOfDate());
        studentRepository.save(dbStudent);
    }

    @Override
    public void deleteStudentById(Integer id) {
        Student dbStudent = readStudentById(id);
        studentRepository.delete(dbStudent);
    }

}
