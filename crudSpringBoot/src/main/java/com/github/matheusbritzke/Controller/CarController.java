package com.github.matheusbritzke.Controller;

import com.github.matheusbritzke.Car.Car;
import com.github.matheusbritzke.Service.CarService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

@RestController
public class CarController {

    private CarService service = new CarService();

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public Car newCar(Car car) {
        return service.newCar(car);
    }

    @RequestMapping(value = "/{plate}", method = RequestMethod.GET)
    public Car findCar(@PathParam(value = "plate") String plate) {
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

    @PutMapping(value = "/updated/{plate}/{powerRating}")
    public Car updateCar(@PathVariable(value = "plate") String plate, @PathVariable(value = "powerRating") double powerRating) {
        return service.updateCar(plate, powerRating);
    }

}
