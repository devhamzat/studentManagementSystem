package com.devhamzat.student_management_system.exceptions;

public class StudentNotFound extends RuntimeException{
    public StudentNotFound (String error){

        super(error);
    }
}
