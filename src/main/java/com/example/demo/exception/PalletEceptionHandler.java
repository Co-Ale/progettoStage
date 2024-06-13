package com.example.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class PalletEceptionHandler {
    @ExceptionHandler(value = {PalletNotFoundException.class})
    public ResponseEntity<Object> handlePalletNotFoundException
        (PalletNotFoundException PalletNotFoundException){
            PalletException PalletException = new PalletException(
                PalletNotFoundException.getMessage(),
                PalletNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
            );

        return new ResponseEntity<>(PalletException, HttpStatus.NOT_FOUND);
    }
}

