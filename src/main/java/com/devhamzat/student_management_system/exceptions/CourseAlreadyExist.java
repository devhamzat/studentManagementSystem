package com.devhamzat.student_management_system.exceptions;

public class CourseAlreadyExist extends RuntimeException{
    public CourseAlreadyExist(String error) {

        super(error);
    }
}
