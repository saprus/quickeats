package com.example.crudOps.rest;

import com.example.crudOps.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @GetMapping("/students")
    public List<Student> getStudents() {

        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("Sid", "Sapru"));
        theStudents.add(new Student("James", "Park"));
        theStudents.add(new Student("Chandler", "Bing"));

        return theStudents;
    }
}
