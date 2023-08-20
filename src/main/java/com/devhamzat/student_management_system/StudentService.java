package com.devhamzat.student_management_system;

import com.devhamzat.student_management_system.exceptions.StudentNotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    public StudentService studentService;



    public StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
//        this.studentIDGenerator = studentIDGenerator;
    }
    List<Students> studentsList = new ArrayList<>();
    public Students addStudents (Students students){
//        students.setStudentId(studentService.generateStudentId());
        return studentRepository.save(students);
    }

    public List<Students> getStudents(){
        return studentRepository.findAll();
    }
    public Students getStudentsById(Long id){
        Optional<Students> optionalCustomer = studentRepository.findById(id);
        if (!optionalCustomer.isPresent()) {
            throw new StudentNotFound("Student not found");
        }
        return optionalCustomer.get();
    }


    public Students updateStudents (Long id,Students students){
        students.setId(id);
        return studentRepository.save(students);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

}

