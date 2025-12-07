package com.yusufcandmrz.springdatajpa.repository;

import com.yusufcandmrz.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "FROM Student")
    public List<Student> findAllStudents();

    @Query(value = "FROM Student student WHERE student.id= :id")
    public Optional<Student> findStudentById(Integer id);
}
