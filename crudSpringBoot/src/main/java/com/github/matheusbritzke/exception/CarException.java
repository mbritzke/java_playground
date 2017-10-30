package com.github.matheusbritzke.exception;

public class CarException extends RuntimeException {

    public CarException() {
        super("CAR NOT FOUND");
    }
}
