package org.devhamzat.enrollment.repository;

import org.devhamzat.enrollment.entity.CandidateApplication;
import org.devhamzat.enrollment.utils.EnrollmentStatus;
import org.devhamzat.enrollment.utils.EnrollmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateApplicationRepository extends JpaRepository<CandidateApplication, String> {
//    Optional<CandidateApplication> findCandidateApplicationByApplicationNumber(String applicationNumber);

    Optional<CandidateApplication> findCandidateApplicationsByEnrollmentType(EnrollmentType enrollmentType);
}
