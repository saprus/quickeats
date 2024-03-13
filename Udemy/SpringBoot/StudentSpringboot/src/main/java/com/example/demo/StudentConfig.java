package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner initDatabase(StudentRepository studentRepository) {
        return args -> {
            studentRepository.save(new Student("Sid", 25, "ss@gmail.com"));
            studentRepository.save(new Student("Nick", 34, "nick@gmail.com"));
        };
    }

}
