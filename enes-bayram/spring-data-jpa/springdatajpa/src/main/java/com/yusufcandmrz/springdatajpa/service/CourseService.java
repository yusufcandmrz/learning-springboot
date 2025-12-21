package com.yusufcandmrz.springdatajpa.service;

import com.yusufcandmrz.springdatajpa.dto.CourseDto;

public interface CourseService {

    public void createCourse(CourseDto courseDto);

    public CourseDto readCourseById(Integer id);
}
