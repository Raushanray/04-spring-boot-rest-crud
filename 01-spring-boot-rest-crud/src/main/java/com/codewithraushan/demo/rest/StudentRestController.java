package com.codewithraushan.demo.rest;

import com.codewithraushan.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    //define the PostConstruct to load the student data ...only once

    @PostConstruct
    public void loadData(){
       theStudents = new ArrayList<>();
        theStudents.add(new Student("Ravi","ranjan"));
        theStudents.add(new Student("Sumit","singh"));
        theStudents.add(new Student("Aayan","sanu"));
    }

    //add code for the "/student" endpoint - return the list of students
    @GetMapping("/student")
    public List<Student> getStudents(){

        return theStudents;
    }

    //define endpoint or "/student/{studentId}" - return student at index
    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //just index into the list ...keep it simple for now

        return theStudents.get(studentId);
    }

}
