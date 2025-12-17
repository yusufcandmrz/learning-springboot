package com.yusufcandmrz.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "student")
@Entity
@Getter
@Setter
public class Student {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birth_of_date")
    private LocalDate birthOfDate;

    @Column(name = "email")
    private String email;

    @Column(name = "identity_number")
    private String identityNumber;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "profile_id")
    private StudentProfile profile;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(
            mappedBy = "student",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            orphanRemoval = true
    )
    private List<StudentCourse> studentCourseList = new ArrayList<>();

    public void addProfile(StudentProfile profile) {
        Objects.requireNonNull(profile, "StudentProfile cannot be null");
        if (this.getProfile() != null) {
            throw new RuntimeException("Student already has a profile");
        }
        this.profile = profile;
    }

    public void assignDepartment(Department department) {
        Objects.requireNonNull(department, "Department cannot be null");
        this.department = department;
    }

    public void addCourse(Course course) {
        StudentCourse studentCourse = new StudentCourse(this, course);
        studentCourseList.add(studentCourse);
        course.getStudentCourseList().add(studentCourse);
    }

}
