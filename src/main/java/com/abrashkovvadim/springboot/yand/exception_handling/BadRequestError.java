package com.abrashkovvadim.springboot.yand.exception_handling;

public class BadRequestError extends ApllicationError{
    public BadRequestError(String massage, int code) {
        super(massage, code);
    }
}
