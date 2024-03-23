package com.rahil.restdemo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahil.restdemo.entity.Student;
//import com.rahil.restdemo.error.StudentErrorResponse;
import com.rahil.restdemo.error.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();

        students.add(new Student("Poornima", "Patel"));
        students.add(new Student("Mario", "Rossi"));
        students.add(new Student("Mary", "Smith"));
    }

    // define endpoint for "/students" - return a lit of students

    @GetMapping("/students")
    public List<Student> gStudents() {
        return students;
    }

    // define endpoint for "/students/{studentId}" -return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if (studentId >= students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return students.get(studentId);
    }

    // // Add an exception handler using @ExceptionHandler
    // @ExceptionHandler
    // public ResponseEntity<StudentErrorResponse>
    // handleException(StudentNotFoundException exception) {

    // // create a Student Error Response

    // StudentErrorResponse error = new
    // StudentErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(),
    // System.currentTimeMillis());

    // // return Response Entity

    // return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    // }

    // @ExceptionHandler
    // public ResponseEntity<StudentErrorResponse> handleExcetion(Exception exp) {
    // // create a Student Error Response

    // StudentErrorResponse error = new
    // StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), exp.getMessage(),
    // System.currentTimeMillis());

    // // return Response Entity

    // return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    // }

}
