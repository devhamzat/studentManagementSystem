package org.devhamzat.enrollment.service.factory;

import org.devhamzat.enrollment.entity.Address;
import org.devhamzat.enrollment.entity.Candidate;
import org.devhamzat.enrollment.entity.CandidateApplication;
import org.devhamzat.enrollment.service.serviceInterface.CandidateEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateEnrollmentFactory {
    @Autowired
    private List<CandidateEnrollmentService> candidateEnrollmentServices;


    public ResponseEntity<String> enrollStudent(Candidate candidate, CandidateApplication candidateApplication, Address address) {
        ResponseEntity<String> enrollmentResponse = null;
        for (CandidateEnrollmentService enrollmentService : candidateEnrollmentServices) {
            if (enrollmentService.getType()== candidateApplication.getEnrollmentType() ) {
                enrollmentResponse = enrollmentService.enrollStudent(candidate,candidateApplication,address);
            }
        }
        return enrollmentResponse;
    }

}
