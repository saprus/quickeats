package com.example.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public List<Car> getCars() {
        return carService.grabCars();
    }


    @PostMapping()
    public void postCars(@RequestBody Car car) {
        carService.addCars(car);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCars(@PathVariable Long id) {
        carService.removeCars(id);
    }
}
