package org.devhamzat.enrollment.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.devhamzat.enrollment.utils.EnrollmentStatus;
import org.devhamzat.enrollment.utils.EnrollmentType;

@Entity
@Table(name = "Application")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidateApplication {
    @Id
    @SequenceGenerator(name = "candidate_application_id_sequence",
            sequenceName = "candidate_application_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "candidate_application_id_sequence"
    )
    private Long id;
    @Column(name = "application_number")
    private String applicationNumber;
    @OneToOne()
    @PrimaryKeyJoinColumn(name = "candidate_id")
    private Candidate candidateId;
    @Column(name = "enrollment_type")
    private EnrollmentType enrollmentType;
    @Column(name = "status")
    private EnrollmentStatus status;
    @Column(name = "course")
    @JsonProperty("course")
    private String programOfChoice;


}
