package com.abrashkovvadim.springboot.yand.exception_handling;

public class EntityNotFoundError extends ApllicationError{
    public EntityNotFoundError(String massage, int code) {
        super(massage, code);
    }
}
