package com.devhamzat.enrollment.repository;

import com.devhamzat.enrollment.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Optional<Candidate> findCandidateByEmail(String email);


}
