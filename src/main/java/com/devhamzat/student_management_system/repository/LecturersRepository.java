package com.devhamzat.student_management_system.repository;

import com.devhamzat.student_management_system.entity.Lecturers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LecturersRepository extends JpaRepository<Lecturers, Long> {

    Optional<Lecturers> findLecturersByEmail(String email);
}
