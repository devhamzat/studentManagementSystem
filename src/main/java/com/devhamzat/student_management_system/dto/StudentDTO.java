package com.devhamzat.student_management_system.dto;

import com.devhamzat.student_management_system.entity.Registration;
import com.devhamzat.student_management_system.entity.Student;
import com.devhamzat.student_management_system.utils.Gender;
import com.devhamzat.student_management_system.utils.StudentType;

import java.time.LocalDate;
import java.util.Set;

public class StudentDTO {
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private StudentType studentType;

    private LocalDate dob;

    private Integer age;

    private String studentId;

    private Set<Registration> registrations;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(Student student) {
        this.firstName = student.getFirstName();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(Student student) {
        this.lastName = student.getLastName();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(Student student) {
        this.email = student.getEmail();
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Student student) {
        this.gender = student.getGender();
    }

    public StudentType getStudentType() {
        return studentType;
    }

    public void setStudentType(Student student) {
        this.studentType = student.getStudentType();
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(Student student) {
        this.dob = student.getDob();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Student student) {
        this.age = student.getAge();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(Student student) {
        this.studentId = student.getStudentId();
    }

    public Set<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Student student) {
        this.registrations = student.getRegistrations();
    }

    @Override
    public String toString() {
        return "Students{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +

                ", gender=" + gender +
                ", dob=" + dob +
                ", age=" + age +
                ", registrations=" + registrations +
                '}';
    }



}


