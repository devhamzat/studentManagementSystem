package com.devhamzat.student_management_system.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;


public class Registration {
    @Id
    private Long id;

    @JsonProperty("studentId")
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    Student students;

    @JsonProperty("courseId")
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    Course courses;

    private LocalDate timeRegistered;

    private Integer grade;

    public Registration(Long id, Student students, Course courses, LocalDate timeRegistered, Integer grade) {
        this.id = id;
        this.students = students;
        this.courses = courses;
        this.timeRegistered = timeRegistered;
        this.grade = grade;
    }

    public Registration() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudents() {
        return students;
    }

    public void setStudents(Student students) {
        this.students = students;
    }

    public Course getCourses() {
        return courses;
    }

    public void setCourses(Course courses) {
        this.courses = courses;
    }

    public LocalDate getTimeRegistered() {
        return timeRegistered;
    }

    public void setTimeRegistered(LocalDate timeRegistered) {
        this.timeRegistered = timeRegistered;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
