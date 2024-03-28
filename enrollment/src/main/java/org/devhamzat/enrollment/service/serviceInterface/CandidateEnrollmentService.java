package org.devhamzat.enrollment.service.serviceInterface;

import org.devhamzat.enrollment.entity.Address;
import org.devhamzat.enrollment.entity.Candidate;
import org.devhamzat.enrollment.entity.CandidateApplication;
import org.devhamzat.enrollment.utils.EnrollmentStatus;
import org.devhamzat.enrollment.utils.EnrollmentType;
import org.springframework.http.ResponseEntity;

public interface CandidateEnrollmentService {
    ResponseEntity<String> enrollStudent(Candidate candidate, CandidateApplication candidateApplication, Address address);
    EnrollmentType getType();
    EnrollmentStatus getStatus();

}
