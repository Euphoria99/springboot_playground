package com.pavanbhat.springboot.cruddemotwo.dao;

import com.pavanbhat.springboot.cruddemotwo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {


    //define field for entitymanager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //execute and get result list
        List<Employee> employees = theQuery.getResultList();

        //return the result
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        //get the employee
//        TypedQuery<Employee> theQuery = entityManager.find(Employee.class, theId);
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //return the employee
        return theEmployee;

    }

    @Override
    public Employee save(Employee theEmployee) {

        //save employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        //return the dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {

        //find the employee by id
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //remove the employee
        entityManager.remove(theEmployee);
    }
}
