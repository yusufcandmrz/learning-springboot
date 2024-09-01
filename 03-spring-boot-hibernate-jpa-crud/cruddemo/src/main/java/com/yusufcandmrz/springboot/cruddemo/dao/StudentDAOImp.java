package com.yusufcandmrz.springboot.cruddemo.dao;

import com.yusufcandmrz.springboot.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImp implements StudentDAO {

    EntityManager entityManager;

    @Autowired
    public StudentDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student getById(Integer studentId) {
        return entityManager.find(Student.class, studentId);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> students = entityManager.createQuery("from Student", Student.class);
        // TypedQuery<Student> students = entityManager.createQuery("from Student order by lastName", Student.class);
        return students.getResultList();
    }

    @Override
    public List<Student> findByLastName(String studentLastName) {
        TypedQuery<Student> students = entityManager.createQuery("from Student where lastName=: lastName", Student.class);
        students.setParameter("lastName", studentLastName);
        return students.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer studentId) {
        Student student = entityManager.find(Student.class, studentId);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("delete from Student").executeUpdate();
    }
}
