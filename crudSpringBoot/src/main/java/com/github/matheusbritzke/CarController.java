package com.github.matheusbritzke;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    private AllCars cars = new AllCars();

    @RequestMapping(method = RequestMethod.GET, value = "newcar/{plate}/{powerRating}")
    @ResponseBody
    public String newCar(@PathVariable(value = "plate") String plate, @PathVariable(value = "powerRating") double powerRating){
        Car car = new Car(plate, powerRating);
        cars.addCar(car);
        return car.toString();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{plate}")
    @ResponseBody
    public String foundCar(@PathVariable(value = "plate") String plate){
        Car foundCar = cars.returnCar(plate);
        if(foundCar.getPlate() == "0")
            return "Car not found";
        return foundCar.toString();
    }

   @RequestMapping("/list")
    public List<Car> carsList(){
        return cars.getCarsList();
   }

   @RequestMapping(method = RequestMethod.GET, value = "/delete/{plate}")
   @ResponseBody
    public String deleteCar(@PathVariable(value = "plate") String plate){
        boolean status = cars.deleteCar(plate);
        if (status)
            return "Car removed";
        return "Car not found";
   }
}
