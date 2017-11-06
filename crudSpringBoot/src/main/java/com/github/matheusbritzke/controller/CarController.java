package com.github.matheusbritzke.controller;

import com.github.matheusbritzke.model.Car;
import com.github.matheusbritzke.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/car")
public class CarController {

    private CarService service = new CarService();

    @RequestMapping(method = RequestMethod.POST)
    public Car newCar(@RequestBody Car car) {
        return service.newCar(car);
    }

    @RequestMapping(value = "/{plate}", method = RequestMethod.GET)
    public Car findCar(@PathVariable(value = "plate") String plate) {
        return service.findCar(plate);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<Car> carsList() {
        return service.getCarsList();
    }

    @RequestMapping(value = "/{plate}", method = RequestMethod.DELETE)
    public Car deleteCar(@PathVariable(value = "plate") String plate) {
        return service.deleteCar(plate);
    }

    @RequestMapping(value = "/{plate}", method = RequestMethod.PUT)
    public Car updateCar(@PathVariable(value = "plate") String plate, @RequestBody Car car) {
        return service.updateCar(plate, car);
    }

}
