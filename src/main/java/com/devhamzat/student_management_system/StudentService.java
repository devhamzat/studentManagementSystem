package com.devhamzat.student_management_system;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    public StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    List<Students> studentsList = new ArrayList<>();
    public Students addStudents (Students students){
        return studentRepository.save(students);
    }

    public List<Students> getStudents(){
        return studentRepository.findAll();
    }
    public Students updateStudents (Long id,Students students){
        students.setId(id);
        return studentRepository.save(students);
    }
}
