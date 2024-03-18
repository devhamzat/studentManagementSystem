package org.devhamzat.enrollment.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.devhamzat.enrollment.utils.Gender;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "candidate")

public class Candidate {
    @Getter
    @Id
    @SequenceGenerator(name = "candidate_id_sequence", sequenceName = "candidate_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidate_id_sequence")
    @Column(name = "id", updatable = false)
    private Long id;
    @Getter
    @Column(name = "first_name", nullable = false)
    @JsonProperty("firstName")
    private String firstName;

    @Getter
    @Column(name = "last_name", nullable = false)
    @JsonProperty("lastName")
    private String lastName;

    @Getter
    @Column(name = "email", nullable = false)
    @JsonProperty("email")
    private String email;

    @Getter
    @Column(name = "address", nullable = false)
    @JsonProperty("address")
    private String address;
    @Getter
    @Column(name = "gender", nullable = false)
    @JsonProperty("sex")
    private Gender gender;
    @Getter
    @Column(name = "date of birth", nullable = false)
    @JsonProperty("Date of birth")
    private LocalDate dob;
    @Transient
    @JsonProperty("age")
    private Integer age;
    @Getter
    @Column(name = "candidate_id")
    private String candidateId;
    @Getter
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    public Address homeAddress;
    @Getter
    @OneToOne
    public CandidateApplication candidateApplication;

    public Candidate() {
    }

    public Candidate(Long id, String firstName, String lastName, String email, String address, Gender gender, LocalDate dob, Integer age, String candidateId, Address homeAddress, CandidateApplication candidateApplication) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.dob = dob;
        this.age = age;
        this.candidateId = candidateId;
        this.homeAddress = homeAddress;
        this.candidateApplication = candidateApplication;
    }

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

    public void setAddress(String address) {
        this.address = address;
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
        this.homeAddress = homeAddress;
    }

    public void setCandidateApplication(CandidateApplication candidateApplication) {
        this.candidateApplication = candidateApplication;
    }
}

