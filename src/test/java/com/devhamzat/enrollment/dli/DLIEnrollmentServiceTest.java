package com.devhamzat.enrollment.dli;

import com.devhamzat.enrollment.entity.Address;
import com.devhamzat.enrollment.entity.Candidate;
import com.devhamzat.enrollment.entity.CandidateApplication;
import com.devhamzat.enrollment.repository.AddressRepository;
import com.devhamzat.enrollment.repository.CandidateApplicationRepository;
import com.devhamzat.enrollment.repository.CandidateRepository;
import com.devhamzat.enrollment.service.dli.DLIEnrollmentService;
import com.devhamzat.enrollment.utils.EnrollmentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DLIEnrollmentServiceTest {
    @Mock
    private CandidateRepository candidateRepository;
    @Mock
    private CandidateApplicationRepository candidateApplicationRepository;
    @Mock
    private AddressRepository addressRepository;
    @InjectMocks
    private DLIEnrollmentService underTest;

    @Test
    void testEnrollStudent() {
        //given
        Candidate candidate = new Candidate();
        CandidateApplication candidateApplication = new CandidateApplication();
        Address address = new Address();
        candidate.setAddress(address);
        candidate.setCandidateApplication(candidateApplication);
        candidate.setEmail("enroll@student.com");
        candidateApplication.setEnrollmentType(EnrollmentType.DLI);
        candidateApplication.setProgramOfChoice("computer science");
        candidateApplication.setApplicationNumber("123456");
        address.setHouseNumber(1);
        address.setStreet("school street");
        address.setCountry("Nigeria");
        address.setState("lagos");

        when(candidateRepository.findCandidateByEmail("enroll@student.com")).thenReturn(Optional.empty());
//        when(candidateApplicationRepository.findCandidateApplicationsByEnrollmentType(EnrollmentType.DLI)).thenReturn(true);
//        when(addressRepository.findByHouseNumberAndStreetAndStateAndAndCountry(address.getHouseNumber(), address.getStreet(), address.getCountry(), address.getState())).getMock();


        //when
        ResponseEntity<String> responseMessage = underTest.enrollStudent(candidate, candidateApplication, address);

        //then
        assertThat(responseMessage.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseMessage.getBody()).isEqualTo("Candidate registered");

    }

    @Test
    void testGetEnrollmentType() {
        //when
        EnrollmentType enrollmentType = underTest.getType();
        //then
        assertThat(enrollmentType).isEqualTo(EnrollmentType.DLI);
    }
}
