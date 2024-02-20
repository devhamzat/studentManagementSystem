package com.devhamzat.student_management_system.service.studentService.foundational;

import com.devhamzat.student_management_system.entity.Student;
import com.devhamzat.student_management_system.repository.StudentRepository;
import com.devhamzat.student_management_system.service.studentService.serviceInterface.StudentRegistrationService;
import com.devhamzat.student_management_system.utils.StudentType;
import com.devhamzat.student_management_system.utils.idGenerator.studentIDGenereator.FoundationalStudentIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoundationalStudentRegistrationService implements StudentRegistrationService {
    @Autowired
    private StudentRepository studentRepository;
    private FoundationalStudentIDGenerator foundationalStudentIDGenerator;

    public FoundationalStudentRegistrationService(StudentRepository studentRepository, FoundationalStudentIDGenerator foundationalStudentIDGenerator) {
        this.foundationalStudentIDGenerator = foundationalStudentIDGenerator;
        this.studentRepository = studentRepository;
    }

    @Override
    public ResponseEntity<String> registerStudent(Student student) {
        //set the student type to dli
        student.setStudentType(StudentType.FOUNDATIONAL);
        //set the studentid field to the student generator  class
        String studentID = foundationalStudentIDGenerator.generateFoundationalStudentId();
        student.setStudentId(studentID);
        //check if email exists
        Optional<Student> studentOptional = studentRepository.findStudentsByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email is already taken");
        }

        studentRepository.save(student);
        return ResponseEntity.ok("Student successfully registered into school of Foundation studies with id : " + studentID);
    }


    @Override
    public StudentType getType() {
        return StudentType.FOUNDATIONAL;
    }
}
