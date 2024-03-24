package com.boot.jpa.reporsitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.jpa.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
