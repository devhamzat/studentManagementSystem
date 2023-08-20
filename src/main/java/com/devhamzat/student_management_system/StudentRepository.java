package com.devhamzat.student_management_system;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface StudentRepository  extends JpaRepository<Students,Long> {
//    @Query(value = "SELECT  nextval('student_id_seq')", nativeQuery = true)
//     static Long getNextStudentIdSequence(){
//        return getNextStudentIdSequence();
//    }
}
