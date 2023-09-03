package com.devhamzat.student_management_system.repository;

import com.devhamzat.student_management_system.entity.Courses;
import com.devhamzat.student_management_system.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Courses,Long> {
    Optional<Courses> findCoursesById(Long id);

}
