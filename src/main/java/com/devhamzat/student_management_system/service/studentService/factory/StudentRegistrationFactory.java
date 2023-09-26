package com.devhamzat.student_management_system.service.studentService.factory;

import com.devhamzat.student_management_system.entity.Student;
import com.devhamzat.student_management_system.service.studentService.serviceInterface.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentRegistrationFactory {
    @Autowired
    private List<StudentRegistrationService> studentRegistrationServices;

    public ResponseEntity<String> registerStudent(Student students) {
        ResponseEntity<String> registrationResponse = null;
        for (StudentRegistrationService registrationService : studentRegistrationServices) {
            if (registrationService.getType() == students.getStudentType()) {
                registrationResponse = registrationService.registerStudent(students);
            }
        }
        return registrationResponse;
    }

}
