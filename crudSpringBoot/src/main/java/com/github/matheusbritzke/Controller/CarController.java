package com.github.matheusbritzke.Controller;

import com.github.matheusbritzke.Crud.Car;
import com.github.matheusbritzke.Service.CarService;
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
    public Car deleteCar(@PathVariable(value = "plate") String plate) {
        return service.deleteCar(plate);
    }

    @PutMapping(value = "/updated/{plate}/{powerRating}")
    public Car updateCar(@PathVariable(value = "plate") String plate, @PathVariable(value = "powerRating") double powerRating) {
        return service.updateCar(plate, powerRating);
    }

}