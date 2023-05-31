package com.abrashkovvadim.springboot.yand.exception_handling;

public class NoSuchEntityException extends Exception{
    public NoSuchEntityException(String message) {
        super(message);
    }
}
