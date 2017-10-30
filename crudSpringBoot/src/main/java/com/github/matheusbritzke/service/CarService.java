package com.github.matheusbritzke.service;

import com.github.matheusbritzke.model.Car;
import com.github.matheusbritzke.persistence.CarsDAO;

import java.util.ArrayList;

public class CarService {

    private CarsDAO carsDAO = new CarsDAO();

    public Car newCar(Car car){
        carsDAO.addCar(car);
        return car;
    }

    public Car findCar(String plate){
        return carsDAO.returnCar(plate);
    }

    public ArrayList<Car> getCarsList() {
        return carsDAO.getCarsList();
    }

    public Car deleteCar(String plate){
        return carsDAO.deleteCar(plate);
    }

    public Car updateCar(String plate, Car car){
        return carsDAO.updateCar(plate, car);
    }
}
