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
        StudentDTO retrievalResponse = null;
        for (StudentRetrievalService retrievalService : retrievalServices) {
            if (retrievalService.studentType(StudentType.valueOf(studentType))) {
                retrievalResponse=  retrievalService.retrieveStudentByStudentId(studentId);
//                return retrievalService.retrieveStudentByStudentId(studentId);
            }
            return retrievalResponse;
        }
        throw new IllegalArgumentException("Unsupported student type: " + studentType);
    }
}
//    public ResponseEntity<String> registerStudent(Student students) {
//        ResponseEntity<String> registrationResponse = null;
//        for (StudentRegistrationService registrationService : studentRegistrationServices) {
//            if (registrationService.getType() == students.getStudentType()) {
//                registrationResponse = registrationService.registerStudent(students);
//            }
//        }
//        return registrationResponse;
//    }
