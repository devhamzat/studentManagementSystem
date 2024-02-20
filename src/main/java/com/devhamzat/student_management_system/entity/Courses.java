package com.devhamzat.student_management_system.entity;

import jakarta.persistence.*;

import java.util.Set;
@Entity
public class Courses {

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
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "courses")
    private Set<Registration> registrations;
  @OneToOne
  @JoinColumn(name = "lecturer_id", referencedColumnName = "id")
  private  Lecturers lecturer;

    public Lecturers getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturers lecturer) {
        this.lecturer = lecturer;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Courses() {
    }
}
