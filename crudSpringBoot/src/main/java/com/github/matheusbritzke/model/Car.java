package com.github.matheusbritzke.model;

public class Car {

    private String plate;
    private double powerRating;

    public Car() {}

    public Car(String plate, double powerRating) {
        this.plate = plate;
        this.powerRating = powerRating;
    }

    public String getPlate() {
        return this.plate;
    }

    public double getPowerRating() {
        return this.powerRating;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setPowerRating(double powerRating){
        this.powerRating = powerRating;
    }

    @Override
    public String toString() {
        return "model{" +
                "plate='" + plate + '\'' +
                ", powerRating=" + powerRating +
                '}';
    }

}
