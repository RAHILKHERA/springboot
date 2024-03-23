package com.rahil.restcurdjparepodemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rahil.restcurdjparepodemo.error.EmployeeErrorResponse;
import com.rahil.restcurdjparepodemo.error.EmployeeNotFoundException;

@ControllerAdvice
public class EmployeeRestExceptionController {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exception) {

        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse(HttpStatus.NOT_FOUND.value(),
                "Something went wrong on server side.", System.currentTimeMillis());

        return new ResponseEntity<EmployeeErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<EmployeeErrorResponse> handleExceptionn(Exception exception) {

        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse(HttpStatus.BAD_REQUEST.value(),
                "Something went Wrong on Server", System.currentTimeMillis());

        return new ResponseEntity<EmployeeErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);

    }
}
