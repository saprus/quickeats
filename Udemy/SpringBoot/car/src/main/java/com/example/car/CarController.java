package com.example.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/car/v1")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public List<CarModel> getCars() {
        return carService.grabCars();
    }

    @PostMapping()
    public void postCars(@RequestBody CarModel carModel) {
        carService.addCars(carModel);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCars(@PathVariable Long id) {
        carService.removeCars(id);
    }

    @PutMapping(path = "/{id}")
    public void putCars(@PathVariable Long id,
                        @RequestParam(required = false) String make,
                        @RequestParam(required = false) Integer carYear
                        ){
        carService.updateCars(id, make, carYear);
    }

}
