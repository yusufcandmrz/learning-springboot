package com.yusufcandmrz.springboot.cruddemo.dao;

import com.yusufcandmrz.springboot.cruddemo.entity.Course;
import com.yusufcandmrz.springboot.cruddemo.entity.Instructor;
import com.yusufcandmrz.springboot.cruddemo.entity.InstructorDetail;

import java.util.List;


public interface AppDAO {

    public void createInstructor(Instructor instructor);

    public Instructor getInstructorById(int id);

    public void deleteInstructorById(int id);

    public InstructorDetail getInstructorDetailById(int id);

    public void deleteInstructorDetailById(int id);

    public List<Course> getCourseListByInstructorId(int id);

    public Instructor getInstructorByIdJoinFetch(int id);

    public void updateInstructor(Instructor instructor);

    public Course getCourseById(int id);

    public void updateCourse(Course course);

    public void deleteCourseById(int id);

    public void createCourseWithReviewList(Course course);

    public Course getCourseWithReviewListById(int id);
}
