package com.codewithraushan.springboot.cruddemo.dao;

import com.codewithraushan.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "members")  //here we add the path new the url is /members
public interface EmployeeRepository extends JpaRepository<Employee , Integer> {

    //that's it .. no need to write any code...
}
