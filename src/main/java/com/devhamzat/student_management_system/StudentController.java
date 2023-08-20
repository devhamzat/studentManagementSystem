package com.devhamzat.student_management_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {
//    @Autowired
//    private StudentIDGenerator studentIDGenerator;


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
  @RequestMapping("/{studentId}")
   public Students getStudentsById(@PathVariable("studentId") Long id){
       return studentService.getStudentsById(id);
   }

   @PutMapping("{studentId}")
    public Students updateStudent(@PathVariable("studentId")Long id, @RequestBody Students students){
       return studentService.updateStudents(id,students);
   }

   @DeleteMapping(value = "/{studentId}")
    public void  deleteStudent(@PathVariable("studentId") Long id){
       studentService.deleteStudent(id);
   }
//   @GetMapping("/MatricNo")
//    public Students getId(){
//       return String.valueOf(studentIDGenerator);
//   }
}
