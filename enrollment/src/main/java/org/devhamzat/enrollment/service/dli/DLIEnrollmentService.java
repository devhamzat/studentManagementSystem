package org.devhamzat.enrollment.service.dli;

import org.devhamzat.enrollment.entity.Address;
import org.devhamzat.enrollment.entity.Candidate;
import org.devhamzat.enrollment.entity.CandidateApplication;
import org.devhamzat.enrollment.repository.AddressRepository;
import org.devhamzat.enrollment.repository.CandidateApplicationRepository;
import org.devhamzat.enrollment.repository.CandidateRepository;
import org.devhamzat.enrollment.service.serviceInterface.CandidateEnrollmentService;
import org.devhamzat.enrollment.utils.EnrollmentStatus;
import org.devhamzat.enrollment.utils.EnrollmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DLIEnrollmentService implements CandidateEnrollmentService {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private CandidateApplicationRepository candidateApplicationRepository;
    @Autowired
    private AddressRepository addressRepository;


    public DLIEnrollmentService(CandidateRepository candidateRepository, CandidateApplicationRepository candidateApplicationRepository, AddressRepository addressRepository) {
        this.candidateRepository = candidateRepository;
        this.candidateApplicationRepository = candidateApplicationRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public ResponseEntity<String> enrollStudent(Candidate candidate, CandidateApplication candidateApplication, Address address) {
        candidateApplication.setEnrollmentType(EnrollmentType.DLI);
        candidate.setCandidateApplication(candidateApplication);
        candidate.setAddress(address);
        Optional<CandidateApplication> candidateApplicationOptional = candidateApplicationRepository.findCandidateApplicationsByEnrollmentType(candidateApplication.getEnrollmentType());
        Optional<Address> addressOptional = addressRepository.findByHouseNumberAndStreetAndStateAndAndCountry(address.getHouseNumber(), address.getStreet(), address.getState(), address.getCountry());
        Optional<Candidate> candidateOptional = candidateRepository.findCandidateByEmail(candidate.getEmail());
        if (candidateOptional.isPresent()&& candidateOptional.get().getCandidateApplication()==null|| candidateOptional.get().getAddress()==null) {
            throw new IllegalStateException("Email is taken");
        }
        candidateRepository.save(candidate);
        candidateApplicationRepository.save(candidateApplication);
        addressRepository.save(address);
        return ResponseEntity.ok("Candidate registered");
    }


    @Override
    public EnrollmentType getType() {
        return EnrollmentType.DLI;
    }

    @Override
    public EnrollmentStatus getStatus() {

        return null;
    }
}
