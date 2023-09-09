package com.devhamzat.student_management_system.service;

import com.devhamzat.student_management_system.entity.Students;
import com.devhamzat.student_management_system.repository.StudentRepository;
import com.devhamzat.student_management_system.utils.StudentType;
import org.springframework.stereotype.Service;

@Service
public class DLIStudentRegistrationService  implements StudentRegistrationService{
    @Override
    public void register(Students students) {
    }

    @Override
    public StudentType getType() {
        return StudentType.DLI;
    }
}