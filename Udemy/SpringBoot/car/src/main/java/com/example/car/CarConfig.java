package com.example.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CarConfig {

    private final RestTemplate restTemplate;

    @Autowired
    public CarConfig(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Bean
    CommandLineRunner initDb(CarRepository carRepository) {
        return args -> {
//            carRepository.save(new Car("Kia", "Green"));
//            carRepository.save(new Car("Honda", "Red"));
            restTemplate.getForObject("http://localhost:3000/data", CarConfig.class);

        };
    }

}
