package com.example.demo.config;

import com.example.demo.dao.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class StudentSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails sid = User.builder()
                .username("sid")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails angela = User.builder()
                .username("angela")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails james = User.builder()
                .username("james")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(sid, angela, james);
    }

    @Bean
    public CommandLineRunner initDatabase(StudentRepository studentRepository) {
        return args -> {
            studentRepository.save(new Student("Sid", "Sapru", "ss@gmail.com"));
            studentRepository.save(new Student("Nick", "Beetham", "nick@gmail.com"));
        };
    }
}
