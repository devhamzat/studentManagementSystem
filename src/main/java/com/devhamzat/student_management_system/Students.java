package com.devhamzat.student_management_system;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Students {
//    @GeneratedValue
//     @Column(unique = true)
//    private StudentIDGenerator studentId;
    @Id
    @SequenceGenerator(name = "student_id_sequence",
            sequenceName = "student_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_id_sequence"
    )

    private Long id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("email")
    private String email;
    @JsonProperty("department")
    private String department;
    @JsonProperty("sex")
    private String gender;


    public Students(


            ) {
//        this.studentId = studentId;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.gender = gender;
    }



//    public StudentIDGenerator getStudentId() {
//
//        return studentId;
//    }
//
//    public void setStudentId(StudentIDGenerator studentId) {
//
//        this.studentId = studentId;
//    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
