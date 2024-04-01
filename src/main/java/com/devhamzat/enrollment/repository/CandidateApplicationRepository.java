package com.devhamzat.enrollment.repository;

import com.devhamzat.enrollment.entity.CandidateApplication;
import com.devhamzat.enrollment.utils.EnrollmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateApplicationRepository extends JpaRepository<CandidateApplication, String> {
//    Optional<CandidateApplication> findCandidateApplicationByApplicationNumber(String applicationNumber);

    Optional<CandidateApplication> findCandidateApplicationsByEnrollmentType(EnrollmentType enrollmentType);
}
