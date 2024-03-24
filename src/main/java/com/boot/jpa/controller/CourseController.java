package com.boot.jpa.controller;

import com.boot.jpa.model.Course;
import com.boot.jpa.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping("/create")
    public Course saveCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

}

// Similarly create controllers for other entities
