package com.devhamzat.student_management_system.exceptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @Value("")
    private String details;

    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<ApplicationError> handleStudentNotFound(StudentNotFound exception) {
        ApplicationError error = new ApplicationError();
        error.setCode(404);
        error.setMessage(exception.getMessage());
        error.setDetails(details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(StudentIDInvalid.class)
    public  ResponseEntity<ApplicationError> handleStudentIdInvalid(StudentIDInvalid exception){
        ApplicationError error = new ApplicationError();
        error.setCode(422);
        error.setMessage(exception.getMessage());
        error.setDetails("try checking your mail again to confirm your student id");
        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @ExceptionHandler(CourseAlreadyExist.class)
    public ResponseEntity<ApplicationError>handlecourseAlreadyExist(CourseAlreadyExist exception){
        ApplicationError error = new ApplicationError();
        error.setCode(409);
        error.setMessage(exception.getMessage());
        error.setDetails("This course input ' already exists");
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
