package com.yusufcandmrz.springdatajpa.service.impl;

import com.yusufcandmrz.springdatajpa.dto.CourseDto;
import com.yusufcandmrz.springdatajpa.entity.Course;
import com.yusufcandmrz.springdatajpa.repository.CourseRepository;
import com.yusufcandmrz.springdatajpa.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void createCourse(CourseDto courseDto) {
        Course course = new Course();
        BeanUtils.copyProperties(courseDto, course);
        courseRepository.save(course);
    }

    @Override
    public CourseDto readCourseById(Integer id) {
        CourseDto courseDto = new CourseDto();
        Course course = findCourseById(id);
        BeanUtils.copyProperties(course, courseDto);
        return courseDto;
    }

    private Course findCourseById(Integer id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }
}
