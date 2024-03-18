package org.devhamzat.enrollment.service.serviceInterface;

import org.devhamzat.enrollment.entity.Candidate;
import org.devhamzat.enrollment.entity.CandidateApplication;
import org.devhamzat.enrollment.utils.EnrollmentType;
import org.springframework.http.ResponseEntity;

public interface CandidateEnrollmentService {
    ResponseEntity<String> enrollStudent(Candidate candidate);
    EnrollmentType getType();
    EnrollmentType getStatus();

}
