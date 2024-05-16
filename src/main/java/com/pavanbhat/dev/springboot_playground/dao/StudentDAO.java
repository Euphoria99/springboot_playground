package com.pavanbhat.dev.springboot_playground.dao;

import com.pavanbhat.dev.springboot_playground.entity.Student;

import java.util.List;

//s2.1: Saving Java Object with JPA
public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);
}
