package com.devhamzat.student_management_system.service.studentService.dli;

import com.devhamzat.student_management_system.entity.Student;
import com.devhamzat.student_management_system.repository.StudentRepository;
import com.devhamzat.student_management_system.service.studentService.serviceInterface.StudentRegistrationService;
import com.devhamzat.student_management_system.utils.StudentType;
import com.devhamzat.student_management_system.utils.idGenerator.studentIDGenereator.DLIStudentIDgenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DLIStudentRegistrationService implements StudentRegistrationService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DLIStudentIDgenerator dliStudentIDgenerator;


    public DLIStudentRegistrationService(StudentRepository studentRepository, DLIStudentIDgenerator dliStudentIDgenerator) {
        this.studentRepository = studentRepository;
        this.dliStudentIDgenerator = dliStudentIDgenerator;
    }

    @Override
    public ResponseEntity<String> registerStudent(Student student) {
        //set the student type to dli
        student.setStudentType(StudentType.DLI);
        //set the studentid field to the student generator  class
        String studentID = dliStudentIDgenerator.generateDLIStudentId();
        student.setStudentId(studentID);
        //check if email exists
        Optional<Student> studentOptional = studentRepository.findStudentsByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email is already taken");
        }

        studentRepository.save(student);
        return ResponseEntity.ok("Student successfully registered into distance learning institute with id : " + studentID);
    }

    @Override
    public StudentType getType() {
        return StudentType.DLI;
    }
}
