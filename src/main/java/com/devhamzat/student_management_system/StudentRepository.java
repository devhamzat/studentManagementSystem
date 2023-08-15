package com.devhamzat.student_management_system;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository  extends JpaRepository<Students,UUID> {

}
