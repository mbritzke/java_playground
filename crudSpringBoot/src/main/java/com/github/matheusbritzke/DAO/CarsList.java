package com.github.matheusbritzke.DAO;

import com.github.matheusbritzke.Car.Car;

import java.util.ArrayList;

public class CarsList {

    private ArrayList<Car> carsList;

    public CarsList() {
        carsList = new ArrayList<>();
    }

    public boolean addCar(Car newCar) {
        if (newCar != null) {
            carsList.add(newCar);
            return true;
        }
        return false;
    }

    public ArrayList<Car> getCarsList() {
        return carsList;
    }

    public Car deleteCar(String plate) {
        for (int i = 0; i < carsList.size(); i++) {
            if(carsList.get(i).getPlate().equalsIgnoreCase(plate)){
                Car car = carsList.get(i);
                carsList.remove(i);
                return car;
            }
        }
        return new Car();
    }

    public Car returnCar(String plate) {
        for (Car iterator : carsList) {
            if (iterator.getPlate().equalsIgnoreCase(plate))
                return iterator;
        }
        return new Car();
    }

    public Car updateCar(String plate, Double powerRating) {
        for (int i = 0; i < carsList.size(); i++) {
            if(carsList.get(i).getPlate().equalsIgnoreCase(plate)){
                carsList.get(i).setPowerRating(powerRating);
                return carsList.get(i);
            }
        }
        return new Car();
    }

}
