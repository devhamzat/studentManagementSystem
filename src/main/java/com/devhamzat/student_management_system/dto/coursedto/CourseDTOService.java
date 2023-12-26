package com.devhamzat.student_management_system.dto.coursedto;

import com.devhamzat.student_management_system.entity.Course;
import com.devhamzat.student_management_system.repository.CourseRepository;
import com.devhamzat.student_management_system.utils.CourseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseDTOService {
    @Autowired
    private CourseRepository courseRepository;

   private CourseDto mapCourseToDTO(CourseType courseType,String courseName,String courseCode){
       Optional<Course> courseOptional = courseRepository.findCourseByCourseTypeAndCourseNameOrCourseCode(courseType,courseName,courseCode);
       if (courseOptional.isPresent()){
           Course course = courseOptional.get();
           CourseDto courseDto = new CourseDto();
           courseDto.setCourseName(course);
           courseDto.setCourseCode(course);
           courseDto.setCourseUnit(course);
           return courseDto;
       }
       return null;
   }
}
