package com.devhamzat.student_management_system.entity;

import com.devhamzat.student_management_system.utils.Gender;
import com.devhamzat.student_management_system.utils.StudentType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;


@Entity
@Table(
        name = "students",
        uniqueConstraints = {
                @UniqueConstraint(name = "student_email_unique", columnNames = "email")
        }
)
@Getter
@Setter
public class Student {

    @Id
    @SequenceGenerator(name = "student_id_sequence",
            sequenceName = "student_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_id_sequence"
    )
    @Column(name = "id",
            updatable = false
    )
    private Long id;

    @Column(name = "first_name",
            nullable = false
    )
    @JsonProperty("firstName")
    private String firstName;

    @Column(name = "last_name",
            nullable = false
    )
    @JsonProperty("lastName")
    private String lastName;

    @Column(name = "email",
            nullable = false
    )
    @JsonProperty("email")
    private String email;

    @Column(name = "address",
            nullable = false
    )
    @JsonProperty("address")
    private String address;
    @Column(name = "gender",
            nullable = false
    )
    @JsonProperty("sex")
    private Gender gender;

    @Column(name = "Student_type",
            nullable = false
    )

    private StudentType studentType;


    @Column(name = "date of birth",
            nullable = false
    )
    @JsonProperty("Date of birth")
    private LocalDate dob;

    public Student(String firstName,
                   String lastName,
                   String email,
                   String address,
                   Gender gender,
                   StudentType studentType,
                   LocalDate dob
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.studentType = studentType;
        this.dob = dob;
        this.age = age;
        this.studentId = studentId;
        this.registrations = registrations;
    }

    @Transient
    @JsonProperty("age")
    private Integer age;

    private String studentId;


    @OneToMany(mappedBy = "students")
    private Set<Registration> registrations;


    public Student() {
    }


    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", dob=" + dob +
                ", age=" + age +
                ", registrations=" + registrations +
                '}';
    }


}
