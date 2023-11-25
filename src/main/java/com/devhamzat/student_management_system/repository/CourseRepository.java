package com.devhamzat.student_management_system.repository;

import com.devhamzat.student_management_system.entity.Course;
import com.devhamzat.student_management_system.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CourseRepository extends JpaRepository<Course,String> {

    Optional<Course> findStudentsByCourseNameOrCourseCode(String courseName,String courseCode );
}
