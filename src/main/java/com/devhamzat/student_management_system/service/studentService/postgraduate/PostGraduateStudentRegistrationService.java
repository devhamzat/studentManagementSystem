package com.devhamzat.student_management_system.service.studentService.postgraduate;

import com.devhamzat.student_management_system.entity.Student;
import com.devhamzat.student_management_system.repository.StudentRepository;
import com.devhamzat.student_management_system.service.studentService.serviceInterface.StudentRegistrationService;
import com.devhamzat.student_management_system.utils.StudentType;
import com.devhamzat.student_management_system.utils.idGenerator.PostGraduateStudentIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostGraduateStudentRegistrationService implements StudentRegistrationService {
    private PostGraduateStudentIDGenerator postGraduateStudentIDGenerator;

    @Autowired
    private StudentRepository studentRepository;

    public PostGraduateStudentRegistrationService(StudentRepository studentRepository, PostGraduateStudentIDGenerator postGraduateStudentIDGenerator) {
        this.postGraduateStudentIDGenerator = postGraduateStudentIDGenerator;
        this.studentRepository = studentRepository;
    }

    @Override
    public ResponseEntity<String> registerStudent(Student student) {
        student.setStudentType(StudentType.POST_GRADUATE);
        String studentID = postGraduateStudentIDGenerator.generatePostgraduateID();
        student.setStudentId(studentID);
        Optional<Student> studentOptional = studentRepository.findStudentsByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
        return ResponseEntity.ok("Student successfully registered into School of Postgraduate studies : " + studentID);
    }


    @Override
    public StudentType getType() {
        return StudentType.POST_GRADUATE;
    }
}
