package com.abrashkovvadim.springboot.yand.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EntityNotFoundError> catchEntityNotFoundError(NoSuchEntityException e){
        return new ResponseEntity<>(new EntityNotFoundError(e.getMessage(),
                HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<BadRequestError> catchBadRequestError(BadDataGivenException e){
        return new ResponseEntity<>(new BadRequestError(e.getMessage(),
                HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<RateLimitError> catchBadRequestError(RateLimitException e){
        return new ResponseEntity<>(new RateLimitError(e.getMessage(),
                HttpStatus.TOO_MANY_REQUESTS.value()), HttpStatus.TOO_MANY_REQUESTS);
    }
}
