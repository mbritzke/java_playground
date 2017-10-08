package com.github.matheusbritzke;

import java.util.ArrayList;

public class AllCars {

    private ArrayList<Car> carsList;

    public AllCars() {
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

    public boolean deleteCar(String plate) {
        for (int i = 0; i < carsList.size(); i++) {
            if(carsList.get(i).getPlate().equalsIgnoreCase(plate)){
                carsList.remove(i);
                return true;
            }
        }
        return false;
    }

    public Car returnCar(String plate) {
        for (Car iterator : carsList) {
            if (iterator.getPlate().equalsIgnoreCase(plate))
                return iterator;
        }
        return new Car("0", -1);
    }

    public Car editCar(Car carModified) {
        for (Car iterator : carsList) {
            if (iterator.getPlate().equalsIgnoreCase(carModified.getPlate())) {
                iterator = carModified;
                return iterator;
            }
        }
        return new Car("0", -1);
    }

}
