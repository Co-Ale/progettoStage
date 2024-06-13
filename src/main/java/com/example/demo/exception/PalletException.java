package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import java.util.Objects;

public class PalletException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;


    public PalletException(String message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return this.message;
    }


    public Throwable getthrowable() {
        return this.throwable;
    }


    public HttpStatus getStatus() {
        return this.httpStatus;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PalletException)) {
            return false;
        }
        PalletException packageEception = (PalletException) o;
        return Objects.equals(message, packageEception.message) && Objects.equals(throwable, packageEception.throwable) && Objects.equals(httpStatus, packageEception.httpStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, throwable, httpStatus);
    }

    @Override
    public String toString() {
        return "{" +
            " message='" + getMessage() + "'" +
            ", throwable='" + getthrowable() + "'" +
            ", httpStatus='" + getStatus() + "'" +
            "}";
    }
    
}
