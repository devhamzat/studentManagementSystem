package com.devhamzat.student_management_system.repository;

import com.devhamzat.student_management_system.entity.Registration;
import com.devhamzat.student_management_system.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration,Long> {

}
