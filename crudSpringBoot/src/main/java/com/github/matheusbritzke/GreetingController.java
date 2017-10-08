package com.github.matheusbritzke;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private AllCars cars = new AllCars();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{plate}/{powerRating}")
    @ResponseBody
    public String newCar(@PathVariable(value = "plate") String plate, @PathVariable(value = "powerRating") double powerRating){
        Car car = new Car(plate, powerRating);
        cars.addCar(car);
        return car.toString();
    }

    
}
