package com.devhamzat.student_management_system.repository;

import com.devhamzat.student_management_system.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    @Query("SELECT s FROM  Student s WHERE s.email =?1")
    Optional<Student> findStudentsByEmail(String email);

//    @Query("SELECT s FROM  Student s WHERE s.studentId = ?1")
//    Optional<Student> findStudentsById(String studentId);
}
