package com.devhamzat.student_management_system.controller;

import com.devhamzat.student_management_system.entity.Student;
import com.devhamzat.student_management_system.service.studentService.StudentRegistrationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/student-management/student")
public class StudentController {


    @Autowired
    private StudentRegistrationFactory studentRegistrationFactory;


    @PostMapping(value = "/register")
    public ResponseEntity<String> addStudents(@RequestBody Student student) {
        ResponseEntity<String> responseEntity = studentRegistrationFactory.registerStudent(student);
        return responseEntity;
    }


}
