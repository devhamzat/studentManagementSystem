package org.devhamzat.enrollment.controller;

import org.devhamzat.enrollment.entity.Address;
import org.devhamzat.enrollment.entity.Candidate;
import org.devhamzat.enrollment.entity.CandidateApplication;
import org.devhamzat.enrollment.service.factory.CandidateEnrollmentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/schoolManagementt")
public class CandidateController {
    @Autowired
    private CandidateEnrollmentFactory candidateEnrollmentFactory;

    @PostMapping(value = "/enroll")
    public ResponseEntity<String> enroll(@RequestBody Candidate candidate, CandidateApplication candidateApplication, Address address) {
        ResponseEntity<String> responseEntity = candidateEnrollmentFactory.enrollStudent(candidate, candidateApplication, address);
        return responseEntity;
    }
}
