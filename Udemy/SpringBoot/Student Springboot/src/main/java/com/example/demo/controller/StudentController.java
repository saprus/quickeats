//package com.example.demo;
//
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping(path="api/")
//public class StudentController {
//
//    private StudentService studentService;
//    private List<Student> theStudents;
//
//    @Autowired
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }
//
//    @PostConstruct
//    public void loadData() {
//        theStudents = new ArrayList<>();
//
//        theStudents.add(new Student("Sid", 25, "ss@gmail.com"));
//        theStudents.add(new Student("James", 21, "james@gmail.com"));
//        theStudents.add(new Student("Jose", 25, "jj@gmail.com"));
//
//    }
//
//    @GetMapping("/students")
//    public List<Student> getStudents() {
//        //return studentService.grabStdudents();
//        return theStudents;
//    }
//
//    @PostMapping
//    public void putStudents(@RequestBody Student student) {
//        studentService.addStudents(student);
//    }
//
//    @PutMapping(path = "/{id}")
//    public void putStudents(@PathVariable Long id,
//                            @RequestParam(required = false) String name,
//                            @RequestParam(required = false) String email,
//                            @RequestParam(required = false) Integer age) {
//        studentService.updateStudent(id, name, email, age);
//    }
//
//    @DeleteMapping(path = "/{id}")
//    public void deleteStudents(@PathVariable Long id) throws Exception {
//        studentService.removeStudents(id);
//    }
//
//}
