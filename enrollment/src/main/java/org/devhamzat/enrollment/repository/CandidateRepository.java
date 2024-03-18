package org.devhamzat.enrollment.repository;

import org.devhamzat.enrollment.entity.Candidate;
import org.devhamzat.enrollment.entity.CandidateApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {

    Optional<Candidate> findCandidateByEmail(String email);
    Optional<Candidate> findCandidateByCandidateApplication(CandidateApplication application);


    Optional<Candidate> findByCandidateId(String candidateId);
}
