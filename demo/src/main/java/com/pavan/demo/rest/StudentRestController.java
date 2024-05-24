package com.pavan.demo.rest;

import com.pavan.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private List<Student> theStudents;

    //define @PostConstruct to load the students data..only once

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Mike","Hussey"));
        theStudents.add(new Student("Mitcheal","Johnson"));
        theStudents.add(new Student("George","Bailey"));
    }

    //define an endpoint
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    //define endpoint "/students/{studentId}" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //check the studentId against list size
        if( (studentId >= theStudents.size()) || (studentId < 0) ){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        //just index into the list
        return theStudents.get(studentId);
    }

    //add an exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        //create a studentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return response entity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //add another execption handler to catch any exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return response entity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
