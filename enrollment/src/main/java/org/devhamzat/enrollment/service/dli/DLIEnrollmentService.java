package org.devhamzat.enrollment.service.dli;

import org.devhamzat.enrollment.entity.Candidate;
import org.devhamzat.enrollment.repository.CandidateRepository;
import org.devhamzat.enrollment.service.serviceInterface.CandidateEnrollmentService;
import org.devhamzat.enrollment.utils.EnrollmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DLIEnrollmentService implements CandidateEnrollmentService {
    @Autowired
    private CandidateRepository candidateRepository;


    public DLIEnrollmentService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public ResponseEntity<String> enrollStudent(Candidate candidate) {
//        candidate.setCandidateApplication(EnrollmentType.DLI);
        Optional<Candidate> candidateOptional = candidateRepository.findCandidateByEmail(candidate.getEmail());
        if (candidateOptional.isPresent()) {
            throw new IllegalStateException("Email is already taken");
        }
        candidateRepository.save(candidate);
        return ResponseEntity.ok("Candidate successfully applied");
    }

    @Override
    public EnrollmentType getType() {
        return EnrollmentType.DLI;
    }

    @Override
    public EnrollmentType getStatus() {
        return null;
    }
}
