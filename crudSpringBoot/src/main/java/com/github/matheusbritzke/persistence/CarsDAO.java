package com.github.matheusbritzke.persistence;

import com.github.matheusbritzke.model.Car;
import com.github.matheusbritzke.exception.CarException;

import java.util.ArrayList;

public class CarsDAO {

    private ArrayList<Car> carsList;

    public CarsDAO() {
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

    public Car deleteCar(String plate){
        for (int i = 0; i < carsList.size(); i++) {
            if(carsList.get(i).getPlate().equalsIgnoreCase(plate)){
                Car car = carsList.get(i);
                carsList.remove(i);
                return car;
            }
        }
        throw new CarException();
    }

    public Car returnCar(String plate) {
        for (Car iterator : carsList) {
            if (iterator.getPlate().equalsIgnoreCase(plate))
                return iterator;
        }
        throw new CarException();
    }

    public Car updateCar(String plate, Car car) {
        for (int i = 0; i < carsList.size(); i++) {
            if(carsList.get(i).getPlate().equalsIgnoreCase(plate)){
                carsList.set(i, car);
                return car;
            }
        }
        throw new CarException();
    }

}
