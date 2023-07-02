package com.codewithraushan.springboot.cruddemo.rest;

import com.codewithraushan.springboot.cruddemo.entity.Employee;
import com.codewithraushan.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    //quick and dirty : inject employee dao (use constructor injection)
    @Autowired
    public EmployeeRestController (EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //expose "/employees" and return the list of employee
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    //add mapping for get "/employee/{employeeId}"
    @GetMapping("/employee/{employeeId}")
    Employee getEmployee(@PathVariable ("employeeId") int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null){
            throw new RuntimeException("Employee id not found :- " + employeeId);
        }
            return theEmployee;
    }

    //add mapping for Post "/employees" - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //also just in case they pass an id is json.. set id to 0
        //this is too force to save a new item ...instead of update

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    //add mapping for Put "/employees" - update existing  employee

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    //add mapping for Delete "/employee/{employeeId}" - delete the existing employee
    @DeleteMapping("/employee/{employeeId}")
    public String  deleteEmployee(@PathVariable ("employeeId") int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null){
            throw new RuntimeException("Employee id not found :- " + employeeId);
        }
       employeeService.deleteById(employeeId);

        return "Deleted employee id :- " + employeeId;
    }


}
