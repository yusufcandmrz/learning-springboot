package com.yusufcandmrz.springdatajpa.service;

import com.yusufcandmrz.springdatajpa.dto.StudentDto;
import com.yusufcandmrz.springdatajpa.dto.StudentDtoIU;
import com.yusufcandmrz.springdatajpa.dto.StudentProfileDto;

import java.util.List;

public interface StudentService {

    public void createStudent(StudentDtoIU student);

    public List<StudentDto> readAllStudents();

    public StudentDto readStudentById(Integer id);

    public void updateStudentById(Integer id, StudentDtoIU student);

    public void deleteStudentById(Integer id);

    public void addStudentProfile(Integer studentId, StudentProfileDto studentProfileDto);
}
