package com.devhamzat.student_management_system.exceptions;

import com.devhamzat.student_management_system.exceptions.ApplicationError;
import com.devhamzat.student_management_system.exceptions.StudentNotFound;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @Value("")
    private String details;

    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<ApplicationError> handleStudentNotFound(StudentNotFound exception, WebRequest webRequest) {
        ApplicationError error = new ApplicationError();
        error.setCode(404);
        error.setMessage(exception.getMessage());
        error.setDetails(details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
