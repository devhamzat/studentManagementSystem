//package com.devhamzat.student_management_system;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class StudentIDGenerator {
//    private  final StudentRepository studentRepository;
//    public  StudentIDGenerator(StudentRepository studentRepository) {
//        this.studentRepository= studentRepository;
//    }
//    public String generateStudentId(){
//        Long nextSequenceValue = StudentRepository.getNextStudentIdSequence();
//        String prefix = "STU";
//        String year = String.valueOf(java.time.LocalDate.now().getYear());
//        String paddedSequence = String.format("%04d", nextSequenceValue);
//        String matricNo =prefix + year + paddedSequence;
//        return matricNo;
//    }
//}
//
