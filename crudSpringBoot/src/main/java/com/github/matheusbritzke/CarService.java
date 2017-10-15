package com.github.matheusbritzke;

import java.util.ArrayList;

public class CarService {

    private CarsList carsList = new CarsList();

    public String newCar(String plate, double powerRating){
        Car car = new Car(plate, powerRating);
        carsList.addCar(car);
        return car.toString();
    }

    public Car findCar(String plate){
        Car car = carsList.returnCar(plate);
        if (car.getPlate()==null)
            return new Car();
        return car;
    }

    public ArrayList<Car> getCarsList() {
        return carsList.getCarsList();
    }

    public String deleteCar(String plate){
        boolean status = carsList.deleteCar(plate);
        if (status)
            return "Car removed";
        return "Car not found";
    }

    public String updateCar(String plate, double powerRating){
        return carsList.updateCar(plate, powerRating);
    }
}
