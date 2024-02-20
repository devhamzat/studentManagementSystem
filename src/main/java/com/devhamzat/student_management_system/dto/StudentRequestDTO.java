package com.devhamzat.student_management_system.dto;

import com.devhamzat.student_management_system.utils.StudentType;

public class StudentRequestDTO {

    private String studentId;
    private StudentType studentType;

    public StudentType getStudentType() {
        return studentType;
    }

    public void setStudentType(StudentType studentType) {
        this.studentType = studentType;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


}
