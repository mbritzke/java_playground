package com.github.matheusbritzke;

public class CarService {

    private CarsList carsList = new CarsList();

    public String newCar(String plate, double powerRating){
        Car car = new Car(plate, powerRating);
        carsList.addCar(car);
        return car.toString();
    }

}
