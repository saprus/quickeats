package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.DECEMBER;
import static java.util.Calendar.JANUARY;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student sid = new Student("Sid", LocalDate.of(2000, Month.DECEMBER, 5), "ss@gmail.com");
            Student mariam = new Student("Mariam", LocalDate.of(2000, Month.JANUARY, 5), "mariam@gmail.com");

            repository.saveAll(
                    List.of(sid, mariam)
            );

        };
    }

}
