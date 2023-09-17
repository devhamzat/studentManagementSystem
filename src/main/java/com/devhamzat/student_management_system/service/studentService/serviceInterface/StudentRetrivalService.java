package com.devhamzat.student_management_system.service.studentService.serviceInterface;

import com.devhamzat.student_management_system.entity.Student;


public interface StudentRetrivalService {
   Student retriveStudentByStudentId(Student student);
    void retriveStudentByEmail();

}