package com.pavanbhat.springboot.cruddemotwo.rest;

import com.pavanbhat.springboot.cruddemotwo.dao.EmployeeDAO;
import com.pavanbhat.springboot.cruddemotwo.entity.Employee;
import com.pavanbhat.springboot.cruddemotwo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // method 2: with service
    private EmployeeService employeeService;


    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){

        return  employeeService.findAll();
    }


    // method 1: without service
//    private EmployeeDAO employeeDAO;


    //quick and dirty: inject employee
//    public EmployeeRestController(EmployeeDAO theEmployeeDAO){
//        employeeDAO = theEmployeeDAO;
//    }

    //expose "/employees" and return a list of employees
//    @GetMapping("/employees")
//    public List<Employee> findAll(){
//        return  employeeDAO.findAll();
//    }

}
