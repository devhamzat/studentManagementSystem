package com.devhamzat.student_management_system.controller;

import com.devhamzat.student_management_system.entity.Student;
import com.devhamzat.student_management_system.service.studentService.StudentRegistrationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/student-management/student")
public class StudentController {

//    @Autowired
//    private StudentService studentService;

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

    @PostMapping(value = "/register")
    public void addStudents(@RequestBody Student students) {
        studentRegistrationFactory.registerStudent(students);
    }

//    @GetMapping
//    public List<Student> getStudents() {
//        return studentService.getStudents();
//    }
//
//    @RequestMapping("/{studentId}")
//    public Student getStudentsById(@PathVariable("studentId") Long id) {
//        return studentService.getStudentsById(id);
//    }
//
//    @Transactional
//    @PutMapping("{studentId}")
//    public void updateStudent(@PathVariable("studentId") Long id,
//                              @RequestBody Student students,
//                              @RequestParam(required = false) String firstName,
//                              @RequestParam(required = false) String lastName,
//                              @RequestParam(required = false) String email
//    ) {
//        studentService.updateStudents(id, students);
//    }
//
//    @DeleteMapping(path = "/{studentId}")
//    public void deleteStudent(
//            @PathVariable("studentId") Long id) {
//        studentService.deleteStudent(id);
//    }
////   @GetMapping("/MatricNo")
////    public Students getId(){
////       return String.valueOf(studentIDGenerator);
////   }
}
