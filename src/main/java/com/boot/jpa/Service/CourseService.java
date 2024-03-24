package com.boot.jpa.Service;

import com.boot.jpa.model.Course;
import com.boot.jpa.reporsitories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // create post request to save course
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
    // Implement other CRUD operations and business logic here
}