package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/students/v1")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.grabStdudents();
    }

    @PostMapping
    public void putStudents(@RequestBody Student student) {
        studentService.addStudents(student);
    }

    @PutMapping(path = "/{id}")
    public void putStudents(@PathVariable Long id,
                            @RequestParam(required = false) String name,
                            @RequestParam(required = false) String email,
                            @RequestParam(required = false) Integer age) {
        studentService.updateStudent(id, name, email, age);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStudents(@PathVariable Long id) throws Exception {
        studentService.removeStudents(id);
    }

}
