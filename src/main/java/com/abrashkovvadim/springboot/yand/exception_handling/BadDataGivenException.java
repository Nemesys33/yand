package com.abrashkovvadim.springboot.yand.exception_handling;

public class BadDataGivenException extends Exception{
    public BadDataGivenException(String message) {
        super(message);
    }
}
