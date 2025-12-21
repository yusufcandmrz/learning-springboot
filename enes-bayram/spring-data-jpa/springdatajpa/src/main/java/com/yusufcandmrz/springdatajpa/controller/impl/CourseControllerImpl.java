package com.yusufcandmrz.springdatajpa.controller.impl;

import com.yusufcandmrz.springdatajpa.controller.CourseController;
import com.yusufcandmrz.springdatajpa.dto.CourseDto;
import com.yusufcandmrz.springdatajpa.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("course")
public class CourseControllerImpl implements CourseController {

    CourseService courseService;

    @Autowired
    public CourseControllerImpl(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    @PostMapping()
    public void createCourse(@RequestBody CourseDto courseDto) {
        courseService.createCourse(courseDto);
    }

    @Override
    @GetMapping("/{id}")
    public CourseDto readCourseById(@PathVariable Integer id) {
        return courseService.readCourseById(id);
    }
}
