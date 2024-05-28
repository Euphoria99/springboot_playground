package com.pavanbhat.springboot.cruddemotwo.service;

import com.pavanbhat.springboot.cruddemotwo.dao.EmployeeDAO;
import com.pavanbhat.springboot.cruddemotwo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    //fields
    private EmployeeDAO employeeDAO;

    //set up constructor injection

    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
