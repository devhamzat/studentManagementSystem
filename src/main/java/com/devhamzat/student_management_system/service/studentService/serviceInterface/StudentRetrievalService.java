package com.devhamzat.student_management_system.service.studentService.serviceInterface;

import com.devhamzat.student_management_system.dto.StudentDTO;
import com.devhamzat.student_management_system.utils.StudentType;


public interface StudentRetrievalService {
    StudentDTO retrieveStudentByStudentId(String studentId);
    boolean studentType(StudentType studentType);




}