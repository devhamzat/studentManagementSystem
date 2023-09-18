package com.devhamzat.student_management_system.service.studentService.serviceInterface;

import com.devhamzat.student_management_system.entity.Student;
import com.devhamzat.student_management_system.utils.StudentType;
import org.springframework.http.ResponseEntity;

public interface StudentRegistrationService {


   ResponseEntity<String> registerStudent(Student students);

    StudentType getType();
}
