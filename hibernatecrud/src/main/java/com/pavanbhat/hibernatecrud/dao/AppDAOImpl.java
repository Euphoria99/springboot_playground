package com.pavanbhat.hibernatecrud.dao;


import com.pavanbhat.hibernatecrud.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements  AppDAO {

    //define field for manager
    private EntityManager entitymanager;

    //inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entitymanager){
        this.entitymanager = entitymanager;
    }

    @Override
    @Transactional
    public void save(Instructor theInStructor) {
        entitymanager.persist(theInStructor);
    }
}
