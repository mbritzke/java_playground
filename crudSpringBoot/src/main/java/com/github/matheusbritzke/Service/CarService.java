package com.github.matheusbritzke.Service;

import com.github.matheusbritzke.Car.Car;
import com.github.matheusbritzke.DAO.CarsList;

import java.util.ArrayList;

public class CarService {

    private CarsList carsList = new CarsList();

    public Car newCar(Car car){
        carsList.addCar(car);
        return car;
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

    public Car deleteCar(String plate){
        return carsList.deleteCar(plate);
    }

    public Car updateCar(String plate, double powerRating){
        return carsList.updateCar(plate, powerRating);
    }
}
