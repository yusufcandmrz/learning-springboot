package com.yusufcandmrz.springdatajpa.service.impl;

import com.yusufcandmrz.springdatajpa.dto.StudentDto;
import com.yusufcandmrz.springdatajpa.dto.StudentDtoIU;
import com.yusufcandmrz.springdatajpa.dto.StudentProfileDto;
import com.yusufcandmrz.springdatajpa.entity.Course;
import com.yusufcandmrz.springdatajpa.entity.Department;
import com.yusufcandmrz.springdatajpa.entity.Student;
import com.yusufcandmrz.springdatajpa.entity.StudentProfile;
import com.yusufcandmrz.springdatajpa.exception.BaseException;
import com.yusufcandmrz.springdatajpa.exception.ErrorMessage;
import com.yusufcandmrz.springdatajpa.exception.MessageType;
import com.yusufcandmrz.springdatajpa.repository.CourseRepository;
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
    CourseRepository courseRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository,
                              DepartmentRepository departmentRepository,
                              CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.courseRepository = courseRepository;
    }

    @Transactional
    @Override
    public void createStudent(StudentDtoIU studentDtoIU) {
        Department dbDepartment = findDepartmentById(studentDtoIU.getDepartmentId());
        Student student = new Student();
        BeanUtils.copyProperties(studentDtoIU, student);
        student.assignDepartment(dbDepartment);
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

    @Transactional
    @Override
    public void updateStudentById(Integer id, StudentDtoIU studentDtoIU) {
        Student dbStudent = findStudentById(id);
        dbStudent.setFullName(studentDtoIU.getFullName());
        dbStudent.setBirthOfDate(studentDtoIU.getBirthOfDate());
        dbStudent.setEmail(studentDtoIU.getEmail());
        dbStudent.setIdentityNumber(studentDtoIU.getIdentityNumber());
        dbStudent.assignDepartment(findDepartmentById(studentDtoIU.getDepartmentId()));
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

    @Transactional
    @Override
    public void addCourse(Integer studentId, Integer courseId) {
        Student dbStudent = findStudentById(studentId);
        Course dbCourse = findCourseById(courseId);
        dbStudent.addCourse(dbCourse);
    }

    private Student findStudentById(Integer id) {
        return studentRepository.findStudentById(id).orElseThrow(() ->
                new BaseException(new ErrorMessage(MessageType.STUDENT_NOT_FOUND)));
    }

    private Department findDepartmentById(Integer id) {
        return departmentRepository.findById(id).orElseThrow(() ->
                new BaseException(new ErrorMessage(MessageType.DEPARTMENT_NOT_FOUND)));
    }

    private Course findCourseById(Integer id) {
        return courseRepository.findById(id).orElseThrow(() ->
                new BaseException(new ErrorMessage(MessageType.COURSE_NOT_FOUND)));
    }
}
