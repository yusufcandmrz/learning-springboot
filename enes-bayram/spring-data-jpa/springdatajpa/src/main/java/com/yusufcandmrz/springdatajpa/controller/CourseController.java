package com.yusufcandmrz.springdatajpa.controller;

import com.yusufcandmrz.springdatajpa.dto.CourseDto;

public interface CourseController {

    public void createCourse(CourseDto courseDto);

    public CourseDto readCourseById(Integer id);
}
