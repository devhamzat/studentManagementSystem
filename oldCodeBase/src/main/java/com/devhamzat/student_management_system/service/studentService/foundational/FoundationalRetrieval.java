package com.devhamzat.student_management_system.service.studentService.foundational;

import com.devhamzat.student_management_system.dto.studentdto.StudentDTO;
import com.devhamzat.student_management_system.dto.studentdto.StudentDTOService;
import com.devhamzat.student_management_system.entity.Student;
import com.devhamzat.student_management_system.exceptions.StudentIDInvalid;
import com.devhamzat.student_management_system.repository.StudentRepository;
import com.devhamzat.student_management_system.service.studentService.serviceInterface.StudentRetrievalService;
import com.devhamzat.student_management_system.utils.StudentType;
import com.devhamzat.student_management_system.utils.idGenerator.studentIDGenereator.FoundationalStudentIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoundationalRetrieval implements StudentRetrievalService {

    @Autowired
    private StudentDTOService studentDTOService;
    @Autowired
    private StudentRepository studentRepository;

    private FoundationalStudentIDGenerator foundationalStudentIDGenerator;

    @Autowired
    private FoundationalRetrieval(StudentRepository studentRepository, FoundationalStudentIDGenerator foundationalStudentIDGenerator) {
        this.studentRepository = studentRepository;
        this.foundationalStudentIDGenerator = foundationalStudentIDGenerator;
    }


    @Override
    public StudentDTO retrieveStudentByStudentId(String studentId) {
        Optional<Student> optionalStudent = studentRepository.findStudentsById(studentId);
        if (optionalStudent == null || !optionalStudent.isPresent()) {
            throw new StudentIDInvalid("Student id is either  invalid or does not exist");
        }
        return studentDTOService.mapStudentToDTO(studentId);
    }

    @Override
    public boolean studentType(StudentType studentType) {
        return studentType.equals(StudentType.FOUNDATIONAL);
    }
}


