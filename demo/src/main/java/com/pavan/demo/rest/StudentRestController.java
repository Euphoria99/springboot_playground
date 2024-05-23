package com.pavan.demo.rest;

import com.pavan.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    //define an endpoint
    @GetMapping("/students")
    public List<Student> getStudents(){

        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("Mike","Hussey"));
        theStudents.add(new Student("Mitcheal","Johnson"));
        theStudents.add(new Student("George","Bailey"));
        return theStudents;
    }
}
