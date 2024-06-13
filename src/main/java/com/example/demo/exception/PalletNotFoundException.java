package com.example.demo.exception;




//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PalletNotFoundException extends RuntimeException {
    public PalletNotFoundException() {
        super();
    }
    public PalletNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public PalletNotFoundException(String message) {
        super(message);
    }
    public PalletNotFoundException(Throwable cause) {
        super(cause);
    }
}