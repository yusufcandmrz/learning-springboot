package com.yusufcandmrz.springdatajpa.service.impl;

import com.yusufcandmrz.springdatajpa.dto.StudentDto;
import com.yusufcandmrz.springdatajpa.dto.StudentDtoIU;
import com.yusufcandmrz.springdatajpa.dto.StudentProfileDto;
import com.yusufcandmrz.springdatajpa.entity.Department;
import com.yusufcandmrz.springdatajpa.entity.Student;
import com.yusufcandmrz.springdatajpa.entity.StudentProfile;
import com.yusufcandmrz.springdatajpa.repository.DepartmentRepository;
import com.yusufcandmrz.springdatajpa.repository.StudentRepository;
import com.yusufcandmrz.springdatajpa.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;
    DepartmentRepository departmentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository,
                              DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void createStudent(StudentDtoIU studentDtoIU) {
        Department dbDepartment = findDepartmentById(studentDtoIU.getDepartmentId());
        Student student = new Student();
        BeanUtils.copyProperties(studentDtoIU, student);
        student.setDepartment(dbDepartment);
        studentRepository.save(student);
    }

    @Override
    public List<StudentDto> readAllStudents() {
        return studentRepository.findAllStudents().stream().map(student -> {
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
    public void updateStudentById(Integer id, StudentDtoIU studentDtoIU) {
        Student dbStudent = findStudentById(id);
        dbStudent.setFullName(studentDtoIU.getFullName());
        dbStudent.setBirthOfDate(studentDtoIU.getBirthOfDate());
        dbStudent.setEmail(studentDtoIU.getEmail());
        dbStudent.setIdentityNumber(studentDtoIU.getIdentityNumber());
        dbStudent.setDepartment(findDepartmentById(studentDtoIU.getDepartmentId()));
        studentRepository.save(dbStudent);
    }

    @Override
    public void deleteStudentById(Integer id) {
        Student dbStudent = findStudentById(id);
        studentRepository.delete(dbStudent);
    }

    @Transactional
    @Override
    public void addStudentProfile(Integer studentId, StudentProfileDto studentProfileDto) {
        Student dbStudent = findStudentById(studentId);
        StudentProfile profile = new StudentProfile();
        profile.setAddress(studentProfileDto.getAddress());
        dbStudent.addProfile(profile);
    }

    private Student findStudentById(Integer id) {
        return studentRepository.findStudentById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    private Department findDepartmentById(Integer id) {
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
    }
}
