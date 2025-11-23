package com.yusufcandmrz.springboot.demo.rest;

import com.yusufcandmrz.springboot.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> students;

    @PostConstruct()
    public void loadData() {
        students = new ArrayList<Student>();
        students.add(new Student("Poornima", "Patel"));
        students.add(new Student("Mario", "Rossi"));
        students.add(new Student("Mary", "Smith"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {

        if (studentId < 0 || studentId > students.size()) {
            throw new StudentNotFoundException("student id is not found -> " + studentId);
        }
        return students.get(studentId);
    }
}
