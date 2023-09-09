package com.devhamzat.student_management_system.controller;

import com.devhamzat.student_management_system.entity.Students;
import com.devhamzat.student_management_system.service.RegistrationService;
import com.devhamzat.student_management_system.service.StudentRegistrationFactory;
import com.devhamzat.student_management_system.service.StudentRegistrationService;
import com.devhamzat.student_management_system.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRegistrationFactory studentRegistrationFactory;


//    @Autowired
//    private RegistrationService registrationService;

//    @PostMapping
//    @RequestMapping("/registercourses")
//    public ResponseEntity<String> registerCourse(@RequestParam Long studentId, @RequestParam Long courseId) {
//        registrationService.registerNewCourses(studentId, courseId);
//        return ResponseEntity.ok("student of " + studentId + " has succesfully registered to " + courseId);
//    }

    @PostMapping
    public void addStudents(@RequestBody Students students) {
        studentRegistrationFactory.registerStudent(students);
    }

    @GetMapping
    public List<Students> getStudents() {
        return studentService.getStudents();
    }

    @RequestMapping("/{studentId}")
    public Students getStudentsById(@PathVariable("studentId") Long id) {
        return studentService.getStudentsById(id);
    }

    @Transactional
    @PutMapping("{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id,
                              @RequestBody Students students,
                              @RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName,
                              @RequestParam(required = false) String email
    ) {
        studentService.updateStudents(id, students);
    }

    @DeleteMapping(path = "/{studentId}")
    public void deleteStudent(
            @PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }
//   @GetMapping("/MatricNo")
//    public Students getId(){
//       return String.valueOf(studentIDGenerator);
//   }
}
