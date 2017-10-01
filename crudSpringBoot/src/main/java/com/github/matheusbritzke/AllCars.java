package com.github.matheusbritzke;

import java.util.ArrayList;
import java.util.List;

public class AllCars {

    private List<Car> carsList;

    public AllCars(){
        carsList = new ArrayList<>();
    }

//- Editar
//- buscar um

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

    public boolean editCar(Car carModified){}

    public Car returnCar(){}

}
