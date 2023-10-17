package com.devhamzat.student_management_system.controller;

import com.devhamzat.student_management_system.dto.StudentDTO;
import com.devhamzat.student_management_system.dto.StudentRequestDTO;
import com.devhamzat.student_management_system.entity.Student;
import com.devhamzat.student_management_system.service.studentService.factory.StudentRegistrationFactory;
import com.devhamzat.student_management_system.service.studentService.factory.StudentRetrievalFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/student-management/student")
public class StudentController {


    @Autowired
    private StudentRegistrationFactory studentRegistrationFactory;
    @Autowired
    private StudentRetrievalFactory studentRetrievalFactory;


    @PostMapping(value = "/register")
    public ResponseEntity<String> addStudents(@RequestBody Student student) {
        ResponseEntity<String> responseEntity = studentRegistrationFactory.registerStudent(student);
        return responseEntity;
    }


    @PostMapping("/retrieve")
    public StudentDTO retrieveStudentById(@RequestBody StudentRequestDTO request) {
        StudentDTO studentDTO = studentRetrievalFactory.retrieveStudentByStudentId(String.valueOf(request.getStudentType()), request.getStudentId());
        return studentDTO;
    }

    @GetMapping(value = "/fetch")
    public ResponseEntity<String> returnString(){
        String string = new String("hello");
        return  ResponseEntity.ok(string);
    }
}
