package com.github.matheusbritzke;

public class Car {

    private String plate;
    private double powerRating;

    public Car(String plate, double powerRating) {
        this.plate = plate;
        this.powerRating = powerRating;
    }

    public String getPlate() {
        return plate;
    }

    public double getPowerRating() {
        return powerRating;
    }

    @Override
    public String toString() {
        return "Car{" +
                "plate='" + plate + '\'' +
                ", powerRating=" + powerRating +
                '}';
    }
}
