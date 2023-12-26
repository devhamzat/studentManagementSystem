package com.devhamzat.student_management_system.dto;

import com.devhamzat.student_management_system.entity.Student;
import com.devhamzat.student_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentDTOService {

    @Autowired
    private StudentRepository studentRepository;
    public StudentDTO mapStudentToDTO(String studentId) {
        Optional<Student> optionalStudent = studentRepository.findStudentsById(studentId);
        Student student= optionalStudent.get();
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setFirstName(student);
        studentDTO.setLastName(student);
        studentDTO.setEmail(student);
        studentDTO.setGender(student);
        studentDTO.setStudentType(student);
        studentDTO.setDob(student);
        studentDTO.setAge(student);
        studentDTO.setStudentId(student);
        studentDTO.setRegistrations(student);
        return studentDTO;
    }
}
