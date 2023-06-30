package com.codewithraushan.springboot.cruddemo.dao;

import com.codewithraushan.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee>  findAll();
}
