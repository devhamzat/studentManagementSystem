package com.devhamzat.student_management_system.service.courseService.undergraduateCourse;

import com.devhamzat.student_management_system.entity.Course;
import com.devhamzat.student_management_system.exceptions.CourseAlreadyExist;
import com.devhamzat.student_management_system.repository.CourseRepository;
import com.devhamzat.student_management_system.service.courseService.serviceInterface.CoursePopulatingService;
import com.devhamzat.student_management_system.utils.CourseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UndergraduateCourseService implements CoursePopulatingService {
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public ResponseEntity<String> populateCourse(Course course) {
        Optional<Course> courseOptional = courseRepository.findStudentsByCourseNameOrCourseCode(course.getCourseName(), course.getCourseCode());
        if (courseOptional.isPresent()) {
            throw new CourseAlreadyExist("course already exist");
        }
        courseRepository.save(course);
        return ResponseEntity.ok("Course with course code " + course.getCourseCode() + " successfully entered");
    }

    @Override
    public CourseType getType() {
        return CourseType.UNDER_GRADUATE_COURSE;
    }
}
