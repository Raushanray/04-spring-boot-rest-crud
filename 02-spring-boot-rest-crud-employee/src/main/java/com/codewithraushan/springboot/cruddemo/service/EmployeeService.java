package com.codewithraushan.springboot.cruddemo.service;

import com.codewithraushan.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
