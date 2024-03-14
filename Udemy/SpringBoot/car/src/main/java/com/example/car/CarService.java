package com.example.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> grabCars() {
        return carRepository.findAll();
    }

    public void addCars(Car car) {
        carRepository.save(car);
    }

    public void removeCars(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);

        if (optionalCar.isPresent()) {
            carRepository.deleteById(id);
        }
        else {
            throw new IllegalStateException("Car not found");
        }
    }
}
