package com.example.lab_1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Something goes wrong...")
public class InternalServerException extends RuntimeException{
    public InternalServerException(String message) {
        super(message);
    }
}
