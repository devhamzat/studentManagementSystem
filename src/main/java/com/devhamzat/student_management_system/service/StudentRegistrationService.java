package com.devhamzat.student_management_system.service;

import com.devhamzat.student_management_system.entity.Students;
import com.devhamzat.student_management_system.utils.StudentType;

public interface StudentRegistrationService {


    void register(Students students);

    StudentType getType();
}
