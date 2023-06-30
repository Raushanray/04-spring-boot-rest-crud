package com.codewithraushan.springboot.cruddemo.dao;

import com.codewithraushan.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    //define fields our entityManager
    private EntityManager entityManager;
    //set up constructor injection
    @Autowired
    public EmployeeDaoImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //execute the query and get the result list
        List<Employee> employees = theQuery.getResultList();

        //return the results
        return employees;
    }
}
