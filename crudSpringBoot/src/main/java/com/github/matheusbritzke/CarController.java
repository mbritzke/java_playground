package com.github.matheusbritzke;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CarController {

    private CarService service = new CarService();

    @PostMapping(value = "/new/{plate}/{powerRating}")
    public Car newCar(@PathVariable(value = "plate") String plate, @PathVariable(value = "powerRating") double powerRating) {
        return service.newCar(plate, powerRating);
    }

    @GetMapping(value = "/found/{plate}")
    public Car findCar(@PathVariable(value = "plate") String plate) {
        return service.findCar(plate);
    }

    @GetMapping("/list")
    public ArrayList<Car> carsList() {
        return service.getCarsList();
    }

    @DeleteMapping(value = "/deleted/{plate}")
    public String deleteCar(@PathVariable(value = "plate") String plate) {
        return service.deleteCar(plate);
    }

    @PutMapping(value = "/updated/{plate}/{powerRating}")
    public String updateCar(@PathVariable(value = "plate") String plate, @PathVariable(value = "powerRating") double powerRating) {
        return service.updateCar(plate, powerRating);
    }

}
