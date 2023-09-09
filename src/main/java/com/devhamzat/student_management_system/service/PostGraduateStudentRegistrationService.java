package com.devhamzat.student_management_system.service;

import com.devhamzat.student_management_system.entity.Students;
import com.devhamzat.student_management_system.utils.StudentType;
import org.springframework.stereotype.Service;

@Service
public class PostGraduateStudentRegistrationService implements  StudentRegistrationService{
    @Override
    public void register(Students students) {

    }

    @Override
    public StudentType getType() {
        return StudentType.POST_GRADUATE;
    }
}
