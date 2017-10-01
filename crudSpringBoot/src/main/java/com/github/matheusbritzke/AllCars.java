package com.github.matheusbritzke;

import java.util.ArrayList;
import java.util.List;

public class AllCars {

    private List<Car> carsList;

    public AllCars(){
        carsList = new ArrayList<>();
    }

    public boolean addCar(Car newCar){
        if(newCar != null){
            carsList.add(newCar);
            return true;
        }
        return false;
    }

    public List<Car> getCarsList() {
        return carsList;
    }

    public boolean deleteCar(Car chosenCar){
        return carsList.remove(chosenCar);
    }

    public Car returnCar(String plate){
        for (Car iterator: carsList) {
            if(iterator.getPlate().equalsIgnoreCase(plate))
                return iterator;
        }
        return new Car("0", -1);
    }

}
