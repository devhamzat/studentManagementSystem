package com.devhamzat.student_management_system.service.courseService.serviceInterface;

import com.devhamzat.student_management_system.entity.Course;
import com.devhamzat.student_management_system.utils.CourseType;
import com.devhamzat.student_management_system.utils.StudentType;
import org.springframework.http.ResponseEntity;

public interface CoursePopulatingService {
    ResponseEntity<String> populateCourse(Course course);
    CourseType getType();
}
