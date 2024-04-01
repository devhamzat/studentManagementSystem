package com.devhamzat.enrollment.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.devhamzat.enrollment.utils.Gender;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "candidate", uniqueConstraints = {@UniqueConstraint(name = "candidate_email_unique", columnNames = "email")})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidate_id_sequence")
    @SequenceGenerator(name = "candidate_id_sequence", sequenceName = "candidate_id_sequence", allocationSize = 1)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    @JsonProperty("firstName")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @JsonProperty("lastName")
    private String lastName;

    @Column(name = "email", nullable = false)
    @JsonProperty("email")
    @Email
    private String email;

    @Column(name = "gender", nullable = false)
    @JsonProperty("sex")
    private Gender gender;

    @Column(name = "date of birth", nullable = false)
    @JsonProperty("Date of birth")
    private LocalDate dob;

    @Transient
    @JsonProperty("age")
    private Integer age;

    @Column(name = "candidate_id")
    private String candidateId;

    @OneToOne()
    @JsonProperty("Address")
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    public Address address;

    @OneToOne()
    @JoinColumn(name = "enrollment_type")
    @JsonProperty("CandidateApplication")
    public CandidateApplication candidateApplication;


    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setGender(Gender gender) {
        this.gender = gender;
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

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public void setHomeAddress(Address homeAddress) {
        this.address = homeAddress;
    }


    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", dob=" + dob +
                ", age=" + age +
                ", candidateId='" + candidateId + '\'' +
                ", homeAddress=" + address +
                ", candidateApplication=" + candidateApplication +
                '}';
    }
}

