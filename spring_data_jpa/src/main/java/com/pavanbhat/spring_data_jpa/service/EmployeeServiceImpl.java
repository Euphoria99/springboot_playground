package com.pavanbhat.spring_data_jpa.service;

import com.pavanbhat.spring_data_jpa.dao.EmployeeRepository;
import com.pavanbhat.spring_data_jpa.entity.Employee;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    //fields
    private EmployeeRepository employeeRepository;

    //set up constructor injection

    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        //
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }


    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if(result.isPresent()){
            theEmployee = result.get();
        }else {
            throw new RuntimeException("Did not find employee id: " + theId);
        }
        return theEmployee;
    }


    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }


    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
