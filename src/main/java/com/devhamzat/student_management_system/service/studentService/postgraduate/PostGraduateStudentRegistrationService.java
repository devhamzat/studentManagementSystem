package com.devhamzat.student_management_system.service.studentService.postgraduate;

import com.devhamzat.student_management_system.entity.Student;
import com.devhamzat.student_management_system.repository.StudentRepository;
import com.devhamzat.student_management_system.service.studentService.serviceInterface.StudentRegistrationService;
import com.devhamzat.student_management_system.utils.StudentType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostGraduateStudentRegistrationService implements StudentRegistrationService {
    private StudentRepository studentRepository;

    public PostGraduateStudentRegistrationService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public ResponseEntity<String> register(Student students) {
        students.setStudentType(StudentType.POST_GRADUATE);
        Optional<Student> studentOptional = studentRepository.findStudentsByEmail(students.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(students);
        return null;
    }


    @Override
    public StudentType getType() {
        return StudentType.POST_GRADUATE;
    }
}
