package com.pavanbhat.springboot.cruddemotwo.dao;

import com.pavanbhat.springboot.cruddemotwo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
