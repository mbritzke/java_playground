package com.github.matheusbritzke.exception;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(){
        super("BOOK NOT FOUND");
    }
}
