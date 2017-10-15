package com.github.matheusbritzke;

import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class CarController {

    private CarService service = new CarService();

    @RequestMapping(method = POST, value = "/new/{plate}/{powerRating}")
    public String newCar(@PathVariable(value = "plate") String plate, @PathVariable(value = "powerRating") double powerRating) {
        return service.newCar(plate, powerRating);
    }

    @RequestMapping(method = GET, value = "/found/{plate}")
    public String findCar(@PathVariable(value = "plate") String plate) {
        return service.findCar(plate);
    }

    @RequestMapping("/list")
    public String carsList() {
        return service.getCarsList();
    }

    @RequestMapping(method = DELETE, value = "/deleted/{plate}")
    public String deleteCar(@PathVariable(value = "plate") String plate) {
        return service.deleteCar(plate);
    }

    @RequestMapping(method = PUT, value = "/updated/{plate}/{powerRating}")
    public String updateCar(@PathVariable(value = "plate") String plate, @PathVariable(value = "powerRating") double powerRating) {
        return service.updateCar(plate, powerRating);
    }

}
