package com.yusufcandmrz.springboot.cruddemo;

import com.yusufcandmrz.springboot.cruddemo.dao.StudentDAO;
import com.yusufcandmrz.springboot.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);
            createMultiStudents(studentDAO);
            // readStudent(studentDAO);
            // queryForStudent(studentDAO);
            // queryForStudentsByLastName(studentDAO);
            // updateStudent(studentDAO);
            // deleteStudent(studentDAO);
            // deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students...");
        int deletedStudentCount = studentDAO.deleteAll();
        System.out.println(deletedStudentCount + " students deleted.");

    }

    private void deleteStudent(StudentDAO studentDAO) {
        System.out.println("Deleting student...");
        Student student = studentDAO.getById(1);
        studentDAO.delete(1);
        System.out.println("Student deleted: " + student);
    }

    private void updateStudent(StudentDAO studentDAO) {
        System.out.println("Getting student...");
        Student student = studentDAO.getById(1);
        System.out.println("Updating student...");
        student.setFirstName("Scooby");
        student.setLastName("Doo");
        student.setEmail("scooby@luv2code.com");
        studentDAO.update(student);
        System.out.println("Student updated: " + student);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastName("Duck");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void queryForStudent(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object...");
        Student student1 = new Student("Duffy", "Duck", "duffy@luv2code.com");

        System.out.println("Saving the student object...");
        studentDAO.save(student1);
        System.out.println("Student object saved. Generated student id: " + student1.getId());

        System.out.println("Retrieving student with id: " + student1.getId());
        Student student2 = studentDAO.getById(student1.getId());
        System.out.println("Found the student: " + student2);
    }

    private void createMultiStudents(StudentDAO studentDAO) {
        System.out.println("Creating new student objects...");
        Student student1 = new Student("John", "Doe", "john@luv2code.com");
        Student student2 = new Student("Mary", "Public", "mary@luv2code.com");
        Student student3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

        System.out.println("Saving the student objects...");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
        System.out.println("Student objects saved. \n" +
                "Generated student1 id: " + student1.getId() + "\n" +
                "Generated student2 id: " + student2.getId() + "\n" +
                "Generated student3 id: " + student3.getId());
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object...");
        Student student = new Student("Paul", "Doe", "paul@luv2code.com");

        System.out.println("Saving the student object...");
        studentDAO.save(student);
        System.out.println("Student object saved. Generated id: " + student.getId());
    }
}
