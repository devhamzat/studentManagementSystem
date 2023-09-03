package com.devhamzat.student_management_system.entity;

import com.devhamzat.student_management_system.utils.Gender;
import jakarta.persistence.*;

@Entity(name = "lecturers")
public class Lecturers {

    @Id
    @SequenceGenerator(name = "lecturer_id_sequence",
            sequenceName = "lecturer_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lecturer_id_sequence"
    )
    @Column(name = "id",
            updatable = false
    )
    private Long id;
    private Gender gender;
    private String firstName;
    private String lastname;
    private String email;
    private String address;
    private  String phoneNumber;

    @OneToOne(mappedBy = "lecturer")
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private  Courses course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }
}
