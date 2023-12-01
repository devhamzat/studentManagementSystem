package com.devhamzat.student_management_system.exceptions;

public class CourseDoesNotExist extends RuntimeException{
    public CourseDoesNotExist(String error){
        super(error);
    }
}
