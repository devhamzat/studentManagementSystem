package com.devhamzat.student_management_system.service.studentService.undergraduate;

import com.devhamzat.student_management_system.entity.Student;
import com.devhamzat.student_management_system.repository.StudentRepository;
import com.devhamzat.student_management_system.service.studentService.serviceInterface.StudentRegistrationService;
import com.devhamzat.student_management_system.utils.StudentType;
import com.devhamzat.student_management_system.utils.idGenerator.UndergradauteStudentIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UnderGraduateStudentRegistrationService implements StudentRegistrationService {
    @Autowired
    private StudentRepository studentRepository;

    private UndergradauteStudentIDGenerator undergradauteStudentIDGenerator;

    public UnderGraduateStudentRegistrationService(UndergradauteStudentIDGenerator undergradauteStudentIDGenerator, StudentRepository studentRepository) {
        this.undergradauteStudentIDGenerator = undergradauteStudentIDGenerator;
        this.studentRepository = studentRepository;
    }

    @Override
    public ResponseEntity<String> registerStudent(Student students) {
        students.setStudentType(StudentType.UNDER_GRADUATE);
        Optional<Student> studentOptional = studentRepository.findStudentsByEmail(students.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email is already taken");
        }
        String studentID = undergradauteStudentIDGenerator.generateUndergraduateStudentId();
        students.setStudentId(studentID);
        studentRepository.save(students);
        return ResponseEntity.ok("Student registered successfully with Id:" + studentID);
    }

    @Override
    public StudentType getType() {
        return StudentType.UNDER_GRADUATE;
    }
}
