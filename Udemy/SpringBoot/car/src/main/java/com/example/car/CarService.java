package com.example.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarModel> grabCars() {
        return carRepository.findAll();
    }

    public void addCars(CarModel carModel) {
        carRepository.save(carModel);
    }

    public void removeCars(Long id) {
        carRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Car not found"));

        carRepository.deleteById(id);
    }

    @Transactional
    public void updateCars(Long id, String make, Integer carYear) {
        CarModel optionalCar = carRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Car not found"));

        if (make != null && !make.isEmpty() && !Objects.equals(make, optionalCar.getMake())) {
            System.out.println("in make");
            optionalCar.setMake(make);
        }
        if (carYear != null && carYear > 0 && !Objects.equals(carYear, optionalCar.getCarYear())) {
            System.out.println("in year");
            optionalCar.setCarYear(carYear);
        }

    }
}
