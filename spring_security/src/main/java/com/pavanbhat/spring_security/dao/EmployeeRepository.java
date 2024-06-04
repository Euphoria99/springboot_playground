package com.pavanbhat.spring_security.dao;


import com.pavanbhat.spring_security.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //
}
