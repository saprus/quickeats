package com.project.quickeats.config;

import com.project.quickeats.model.Grocery;
import com.project.quickeats.repository.GroceryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(GroceryRepository repository) {
        return args -> {
            repository.save(new Grocery("Milk", "Dairy"));
            repository.save(new Grocery("Eggs", "Dairy"));
            repository.save(new Grocery("Fish", "Seafood"));
        };
    }

}
