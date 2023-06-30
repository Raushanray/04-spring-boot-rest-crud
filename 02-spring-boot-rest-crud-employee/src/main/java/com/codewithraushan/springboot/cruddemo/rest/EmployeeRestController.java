package com.codewithraushan.springboot.cruddemo.rest;

import com.codewithraushan.springboot.cruddemo.dao.EmployeeDao;
import com.codewithraushan.springboot.cruddemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDao employeeDao;

    //quick and dirty : inject employee dao (use constructor injection)
    public EmployeeRestController (EmployeeDao theEmployeeDao){
        employeeDao = theEmployeeDao;
    }

    //expose "/employees" and return the list of employee
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDao.findAll();
    }
}
