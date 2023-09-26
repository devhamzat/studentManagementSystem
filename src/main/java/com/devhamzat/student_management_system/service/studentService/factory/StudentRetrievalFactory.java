package com.devhamzat.student_management_system.service.studentService.factory;

import com.devhamzat.student_management_system.dto.StudentDTO;
import com.devhamzat.student_management_system.service.studentService.serviceInterface.StudentRetrievalService;
import com.devhamzat.student_management_system.utils.StudentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentRetrievalFactory {
    private final List<StudentRetrievalService> retrievalServices;

    @Autowired
    public StudentRetrievalFactory(List<StudentRetrievalService> retrievalServices) {
        this.retrievalServices = retrievalServices;
    }

    public StudentDTO retrieveStudentByStudentId(String studentType, String studentId) {
        for (StudentRetrievalService retrievalService : retrievalServices) {
            if (retrievalService.studentType(StudentType.valueOf(studentType))) {
                return retrievalService.retrieveStudentByStudentId(studentId);
            }
        }
        throw new IllegalArgumentException("Unsupported student type: " + studentType);
    }
}
