package com.devhamzat.student_management_system.entity;

import com.devhamzat.student_management_system.utils.CourseType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Course {

    @Id
    @SequenceGenerator(name = "course_id_sequence",
            sequenceName = "course_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_id_sequence"
    )
    @Column(name = "id",
            updatable = false
    )
    private Long id;
    @Column(name = "course_name",
            nullable = false
    )
    @JsonProperty("course name")
    private String courseName;
    @Column(name = "course_code",
            nullable = false
    )
    @JsonProperty("course code")
    private String courseCode;
    @Column(name = "course_unit",
            nullable = false
    )
    @JsonProperty("course unit")
    private Integer courseUnit;
    @OneToMany(mappedBy = "courses")
    private Set<Registration> registrations;
    @OneToOne
    @JoinColumn(name = "lecturer_id", referencedColumnName = "id")
    private Lecturers lecturer;

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    private CourseType courseType;

    public Course(Long id,
                  String courseName,
                  String courseCode,
                  Integer courseUnit,
                  Set<Registration> registrations,
                  Lecturers lecturer) {
        this.id = id;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseUnit = courseUnit;
        this.registrations = registrations;
        this.lecturer = lecturer;
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Integer getCourseUnit() {
        return courseUnit;
    }

    public void setCourseUnit(Integer courseUnit) {
        this.courseUnit = courseUnit;
    }

    public Set<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<Registration> registrations) {
        this.registrations = registrations;
    }

    public Lecturers getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturers lecturer) {
        this.lecturer = lecturer;
    }
}
