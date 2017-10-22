package com.github.matheusbritzke.service;

import com.github.matheusbritzke.car.Car;
import com.github.matheusbritzke.persistence.CarsList;

import java.util.ArrayList;

public class CarService {

    private CarsList carsList = new CarsList();

    public Car newCar(Car car){
        carsList.addCar(car);
        return car;
    }

    public Car findCar(String plate){
        return carsList.returnCar(plate);
    }

    public ArrayList<Car> getCarsList() {
        return carsList.getCarsList();
    }

    public Car deleteCar(String plate){
        return carsList.deleteCar(plate);
    }

    public Car updateCar(String plate, double powerRating){
        return carsList.updateCar(plate, powerRating);
    }
}
