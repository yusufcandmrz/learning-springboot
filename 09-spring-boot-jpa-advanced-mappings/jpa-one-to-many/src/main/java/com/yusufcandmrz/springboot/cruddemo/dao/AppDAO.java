package com.yusufcandmrz.springboot.cruddemo.dao;

import com.yusufcandmrz.springboot.cruddemo.entity.Instructor;
import com.yusufcandmrz.springboot.cruddemo.entity.InstructorDetail;


public interface AppDAO {

    public void createInstructor(Instructor instructor);

    public Instructor getInstructorById(int id);

    public void deleteInstructorById(int id);

    public InstructorDetail getInstructorDetailById(int id);

    public void deleteInstructorDetailById(int id);
}
