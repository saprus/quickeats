//package com.example.demo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//
//@Service
//public class StudentService {
//
//
//    private final StudentRepository studentRepository;
//
//    @Autowired
//    public StudentService(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }
//
//    public List<Student> grabStdudents() {
//        return studentRepository.findAll();
//    }
//
//    public void addStudents(Student student) {
//        studentRepository.save(student);
//    }
//
//    @Transactional
//    public void updateStudent(Long id, String name, String email, Integer age) {
//
//        Student student = studentRepository.findById(id)
//                .orElseThrow(() -> new IllegalStateException("Student with that id does not exist"));
//
//        if (name != null && !name.isEmpty() && !Objects.equals(name, student.getName())) {
//            System.out.println("In name");
//            student.setName(name);
//        }
//
//        if (email != null && !email.isEmpty() && !Objects.equals(email, student.getEmail())) {
//            Optional<Student> optionalStudent = studentRepository.findStudentByEmail(email);
//            System.out.println("in email");
//            if(optionalStudent.isPresent()) {
//                throw new IllegalStateException("Email is Taken");
//            }
//            else {
//                System.out.println("email set");
//                student.setEmail(email);
//            }
//        }
//        if (age != null && !Objects.equals(age, student.getAge())) {
//            System.out.println("In age");
//            student.setAge(age);
//        }
//    }
//
//    public void removeStudents(Long id) throws Exception {
//        Optional<Student> student = studentRepository.findById(id);
//
//        if (student.isPresent()) {
//            studentRepository.deleteById(id);
//        }
//        else {
//            throw new Exception("No student with id " + id +  " found");
//        }
//
//
//    }
//
//
//}
