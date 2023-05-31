package com.abrashkovvadim.springboot.yand.exception_handling;

public class RateLimitException extends Exception{
    public RateLimitException(String message) {
        super(message);
    }
}
