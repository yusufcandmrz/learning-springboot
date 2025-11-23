package com.yusufcandmrz.springboot.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(StudentNotFoundException exc) {
        StudentErrorResponse exception = new StudentErrorResponse();
        exception.setStatus(HttpStatus.NOT_FOUND.value());
        exception.setMessage(exc.getMessage());
        exception.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentExpcetion(Exception exc) {
        StudentErrorResponse exception = new StudentErrorResponse();
        exception.setStatus(HttpStatus.BAD_REQUEST.value());
        exception.setMessage(exc.getMessage());
        exception.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}
