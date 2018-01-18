package com.github.matheusbritzke.exception;

public class BookException extends RuntimeException{

    public BookException(){
        super("BOOK NOT FOUND");
    }
}
