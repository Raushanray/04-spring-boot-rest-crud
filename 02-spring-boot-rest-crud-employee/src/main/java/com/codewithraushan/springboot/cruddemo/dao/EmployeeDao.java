package com.codewithraushan.springboot.cruddemo.dao;

import com.codewithraushan.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee>  findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
