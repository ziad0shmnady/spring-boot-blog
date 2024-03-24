package com.boot.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

import org.hibernate.mapping.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "auther")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Auther extends BaseEntity {

    private String name;
    private String description;
    // createdAt column
    @ManyToMany
    @JoinTable(name = "course_auther", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "auther_id"))

    private java.util.List<Course> courses;
}
