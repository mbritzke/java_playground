package com.github.matheusbritzke;

public class CarService {

    private CarsList carsList = new CarsList();

    public String newCar(String plate, double powerRating){
        Car car = new Car(plate, powerRating);
        carsList.addCar(car);
        return car.toString();
    }

    public String foundCar(String plate){
        Car car = carsList.returnCar(plate);
        if (car.getPlate().equalsIgnoreCase("0"))
            return "Car not found";
        return car.toString();
    }

}
