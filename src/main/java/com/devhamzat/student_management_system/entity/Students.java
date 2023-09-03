package com.devhamzat.student_management_system.entity;

import com.devhamzat.student_management_system.utils.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

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
public class Students {

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

    @Column(name = "date of birth",
            nullable = false
    )
    @JsonProperty("Date of birth")
    private LocalDate dob;
    @Transient
    @JsonProperty("age")
    private Integer age;

    @Column(
            name = "mobile_number",
            nullable = false
    )
    @JsonProperty("phoneNumber")
    private Integer mobileNumber;
    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @OneToMany(mappedBy = "students")
    private Set<Registration> registrations;


    public Students() {
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
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
                ", mobileNumber=" + mobileNumber +
                ", registrations=" + registrations +
                '}';
    }

    public Set<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<Registration> registrations) {
        this.registrations = registrations;
    }
}
