package com.devhamzat.student_management_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
   @PutMapping("{studentId}")
    public Students updateStudent(@PathVariable("studentId")Long id, @RequestBody Students students){
       return studentService.updateStudents(id,students);
   }

}
