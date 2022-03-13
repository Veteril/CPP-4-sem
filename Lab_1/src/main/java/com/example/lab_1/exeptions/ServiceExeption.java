package com.example.lab_1.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Wrong value...")
public class ServiceExeption extends Exception {

    public  ServiceExeption(String message) {
        super(message);
    }
}
