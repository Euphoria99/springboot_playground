package com.pavanbhat.springboot.cruddemotwo.service;

import com.pavanbhat.springboot.cruddemotwo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
