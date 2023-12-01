package com.devhamzat.student_management_system.service.courseService.factory;

import com.devhamzat.student_management_system.entity.Course;
import com.devhamzat.student_management_system.service.courseService.serviceInterface.CourseDeletingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseDeletingFactory {
    @Autowired
    private List<CourseDeletingService> courseDeletingServices;

    public ResponseEntity<String> deleteCourse(Course course) {
        ResponseEntity<String> deleteResponse = null;
        for (CourseDeletingService deletingService : courseDeletingServices) {
            if (deletingService.getType() == course.getCourseType()) {
                deleteResponse = deletingService.deleteCourse(course);
            }

        }
        return deleteResponse;
    }
}
