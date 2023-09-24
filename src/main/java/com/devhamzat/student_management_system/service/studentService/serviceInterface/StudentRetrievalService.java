package com.devhamzat.student_management_system.service.studentService.serviceInterface;

import com.devhamzat.student_management_system.entity.Student;


public interface StudentRetrievalService {
   Student retrieveStudentByStudentId(Student student);
    void retrieveStudentByEmail();

}