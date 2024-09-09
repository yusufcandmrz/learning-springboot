package com.yusufcandmrz.springboot.cruddemo.dao;

import com.yusufcandmrz.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImp implements EmployeeDAO {

    EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> employees = entityManager.createQuery("from Employee", Employee.class);
        return employees.getResultList();
    }

    @Override
    public Employee findById(int employeeId) {
        return entityManager.find(Employee.class, employeeId);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void delete(int employeeId) {
        Employee employee = findById(employeeId);
        entityManager.remove(employee);
    }
}
