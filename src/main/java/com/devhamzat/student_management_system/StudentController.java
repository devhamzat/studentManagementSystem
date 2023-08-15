package com.devhamzat.student_management_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
   @PostMapping
    public Students addStudents(@RequestBody Students students){
       return studentService.addStudents(students);
   }
   @GetMapping
    public List<Students> getStudents(){
       return studentService.getStudents();
   }
}
