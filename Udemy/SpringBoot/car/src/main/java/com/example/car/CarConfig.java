package com.example.car;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig {

    @Bean
    public CommandLineRunner initDatabase(CarRepository carRepository) {
        return args -> {
            carRepository.save(new CarModel("Kia", 2023));
            carRepository.save(new CarModel("Honda", 2001));
        };
    }
}
