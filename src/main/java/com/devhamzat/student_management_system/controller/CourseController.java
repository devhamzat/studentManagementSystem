package com.devhamzat.student_management_system.controller;

import com.devhamzat.student_management_system.entity.Course;
import com.devhamzat.student_management_system.service.courseService.factory.CourseDeletingFactory;
import com.devhamzat.student_management_system.service.courseService.factory.CoursePopulatingServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student-management/course")
public class CourseController {
    @Autowired
    private CoursePopulatingServiceFactory coursePopulatingServiceFactory;
    @Autowired
    private CourseDeletingFactory deletingFactory;

    @PostMapping(value = "/populate")
    public ResponseEntity<String> populateCourse(@RequestBody Course course){
        ResponseEntity<String> responseEntity = coursePopulatingServiceFactory.populateCourse(course);
        return responseEntity;
    }
    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteCourse(@RequestBody Course course){
        ResponseEntity<String> responseEntity = deletingFactory.deleteCourse(course);
        return responseEntity;
    }

}
