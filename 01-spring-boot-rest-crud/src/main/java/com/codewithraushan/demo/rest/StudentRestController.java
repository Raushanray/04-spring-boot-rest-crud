package com.codewithraushan.demo.rest;

import com.codewithraushan.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    //add code for the "/student" endpoint - return the list of students
    @GetMapping("/student")
    public List<Student> getStudents(){
        List<Student> theStudents = new ArrayList<>();
        theStudents.add(new Student("Ravi","ranjan"));
        theStudents.add(new Student("Sumit","singh"));
        theStudents.add(new Student("Aayan","sanu"));
        return theStudents;
    }

}
