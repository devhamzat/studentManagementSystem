//package com.devhamzat.student_management_system.utils;
//
//import com.devhamzat.student_management_system.entity.Student;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentMap;
//
//public class StudentIDMapper {
//    private final Map<String, Student> studentIDToStudentMap = new ConcurrentHashMap<>();
//    public void registerStudent(Student student) {
//        studentIDToStudentMap.put(student.getStudentId(), student);
//    }
//
//    public Student getStudentById(String studentId) {
//        return studentIDToStudentMap.get(studentId);
//    }
//}


