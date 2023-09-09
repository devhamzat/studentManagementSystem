package com.devhamzat.student_management_system.service;

import com.devhamzat.student_management_system.entity.Students;
import com.devhamzat.student_management_system.exceptions.StudentNotFound;
import com.devhamzat.student_management_system.repository.StudentRepository;
import com.devhamzat.student_management_system.utils.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    public StudentRepository studentRepository;


    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }

    public void addStudents(Students students) {

        Optional<Students> studentOptional = studentRepository
                .findStudentsByEmail(students.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        } else if (students.getRoleType() != RoleType.student) {
            throw new IllegalStateException("role type not compatible");
        }

        studentRepository.save(students);


    }

    public List<Students> getStudents() {
        return studentRepository.findAll();
    }

    public Students getStudentsById(Long id) {
        Optional<Students> optionalStudents = studentRepository.findById(id);
        if (!optionalStudents.isPresent()) {
            throw new StudentNotFound("Student not found");
        }
        return optionalStudents.get();
    }

    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("student with id " + id + "does not exist");
        }
        studentRepository.deleteById(id);
    }

    public void updateStudents(Long id, Students students) {
        students.setId(id);
        studentRepository.save(students);
    }
}

