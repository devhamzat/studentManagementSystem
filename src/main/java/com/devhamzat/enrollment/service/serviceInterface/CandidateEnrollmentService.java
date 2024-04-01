package com.devhamzat.enrollment.service.serviceInterface;

import com.devhamzat.enrollment.entity.Address;
import com.devhamzat.enrollment.entity.Candidate;
import com.devhamzat.enrollment.entity.CandidateApplication;
import com.devhamzat.enrollment.utils.EnrollmentStatus;
import com.devhamzat.enrollment.utils.EnrollmentType;
import org.springframework.http.ResponseEntity;

public interface CandidateEnrollmentService {
    ResponseEntity<String> enrollStudent(Candidate candidate, CandidateApplication candidateApplication, Address address);
    EnrollmentType getType();
    EnrollmentStatus getStatus();

}
