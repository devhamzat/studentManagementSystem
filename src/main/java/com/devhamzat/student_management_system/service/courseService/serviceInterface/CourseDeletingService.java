package com.devhamzat.student_management_system.service.courseService.serviceInterface;

import com.devhamzat.student_management_system.entity.Course;
import com.devhamzat.student_management_system.utils.CourseType;
import org.springframework.http.ResponseEntity;

public interface CourseDeletingService {
    ResponseEntity<String> deleteCourse(Course course);

    CourseType getType();
}
