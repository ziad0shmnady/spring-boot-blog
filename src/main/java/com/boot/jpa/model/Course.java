package com.boot.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Course extends BaseEntity {

    private String title;
    private String description;
    private int duration;

    @ManyToMany
    @JoinTable(name = "course_auther", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "auther_id"))
    private java.util.List<Auther> Authers;

    @OneToMany(mappedBy = "course")
    private java.util.List<Section> sections;

}
