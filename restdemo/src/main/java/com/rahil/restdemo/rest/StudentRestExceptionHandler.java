package com.rahil.restdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rahil.restdemo.error.StudentErrorResponse;
import com.rahil.restdemo.error.StudentNotFoundException;

@ControllerAdvice
public class StudentRestExceptionHandler {

    // add exception handling code here
    // Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {

        // create a Student Error Response

        StudentErrorResponse error = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(),
                System.currentTimeMillis());

        // return Response Entity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleExcetion(Exception exp) {
        // create a Student Error Response

        StudentErrorResponse error = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), exp.getMessage(),
                System.currentTimeMillis());

        // return Response Entity

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
