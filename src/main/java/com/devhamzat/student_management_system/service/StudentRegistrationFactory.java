package com.devhamzat.student_management_system.service;

import com.devhamzat.student_management_system.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentRegistrationFactory {
    @Autowired
    private List<StudentRegistrationService> studentRegistrationServices;
    public void registerStudent(Students students){
        for(StudentRegistrationService  registrationService:  studentRegistrationServices){
            if(registrationService.getType()== students.getStudentType()){
                registrationService.register(students);
            }
        }
    }
}
