package com.yusufcandmrz.springdatajpa.repository;

import com.yusufcandmrz.springdatajpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
