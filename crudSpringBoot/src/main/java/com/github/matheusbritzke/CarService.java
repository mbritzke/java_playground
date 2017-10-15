package com.github.matheusbritzke;

public class CarService {

    private CarsList carsList = new CarsList();

    public String newCar(String plate, double powerRating){
        Car car = new Car(plate, powerRating);
        carsList.addCar(car);
        return car.toString();
    }

    public String findCar(String plate){
        Car car = carsList.returnCar(plate);
        if (car.getPlate().equalsIgnoreCase("0"))
            return "Car not found";
        return car.toString();
    }

    public String getCarsList() {
        return carsList.getCarsList().toString();
    }

    public String deleteCar(String plate){
        boolean status = carsList.deleteCar(plate);
        if (status)
            return "Car removed";
        return "Car not found";
    }

    public String updateCar(String plate, double powerRating){
        return carsList.updateCar(plate, powerRating);
    }
}
