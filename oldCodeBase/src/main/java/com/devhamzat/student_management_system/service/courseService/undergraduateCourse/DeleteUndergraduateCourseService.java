package com.devhamzat.student_management_system.service.courseService.undergraduateCourse;

import com.devhamzat.student_management_system.entity.Course;
import com.devhamzat.student_management_system.exceptions.CourseDoesNotExist;
import com.devhamzat.student_management_system.repository.CourseRepository;
import com.devhamzat.student_management_system.service.courseService.serviceInterface.CourseDeletingService;
import com.devhamzat.student_management_system.utils.CourseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteUndergraduateCourseService implements CourseDeletingService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public ResponseEntity<String> deleteCourse(Course course) {
        Optional<Course> courseOptional = courseRepository.findStudentsByCourseNameOrCourseCode(course.getCourseName(), course.getCourseCode());
        Course courseToDelete = courseOptional.get();
        if (!courseOptional.isPresent()) {
            throw new CourseDoesNotExist("this course does not exist");
        }
        courseRepository.delete(courseToDelete);
        return ResponseEntity.ok("Successfully deleted");
    }

    @Override
    public CourseType getType() {
        return CourseType.UNDER_GRADUATE_COURSE;
    }
}
