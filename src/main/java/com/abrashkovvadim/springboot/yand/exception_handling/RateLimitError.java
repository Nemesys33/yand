package com.abrashkovvadim.springboot.yand.exception_handling;

public class RateLimitError extends ApllicationError{
    public RateLimitError(String massage, int code) {
        super(massage, code);
    }
}
