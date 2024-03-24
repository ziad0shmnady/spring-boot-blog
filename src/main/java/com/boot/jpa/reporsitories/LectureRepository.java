package com.boot.jpa.reporsitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.jpa.model.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {

}
