package com.devhamzat.student_management_system.entity;

import com.devhamzat.student_management_system.utils.Gender;
import com.devhamzat.student_management_system.utils.RoleType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;



@Table(
        name = "lecturers",
        uniqueConstraints = {
                @UniqueConstraint(name = "lecturers_email_unique", columnNames = "email")
        }
)
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

    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastname;
    @JsonProperty("email")
    private String email;
    @Column(name = "gender",
            nullable = false
    )
    @JsonProperty("sex")
    private Gender gender;
    @JsonProperty("address")
    private String address;
    @Column(name = "roletype",
            nullable = false
    )
    @JsonProperty("role type ")
    private RoleType roleType;

    @OneToOne(mappedBy = "lecturer")
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    @Override
    public String toString() {
        return "Lecturers{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", roleType=" + roleType +
                ", course=" + course +
                '}';
    }
}
