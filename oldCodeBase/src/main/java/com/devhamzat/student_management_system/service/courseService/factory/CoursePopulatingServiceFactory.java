package com.devhamzat.student_management_system.service.courseService.factory;

import com.devhamzat.student_management_system.entity.Course;
import com.devhamzat.student_management_system.service.courseService.serviceInterface.CoursePopulatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursePopulatingServiceFactory {
    @Autowired
    private List<CoursePopulatingService> coursePopulatingServices;

    public ResponseEntity<String> populateCourse(Course course) {
        ResponseEntity<String> populatingResponse = null;
        for (CoursePopulatingService populatingService : coursePopulatingServices) {
            if (populatingService.getType() == course.getCourseType()) {
                populatingResponse = populatingService.populateCourse(course);
            }

        }
        return populatingResponse;
    }
}
