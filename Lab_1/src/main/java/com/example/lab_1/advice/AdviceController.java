package com.example.lab_1.advice;

import com.example.lab_1.exceptions.InternalServerException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import com.example.lab_1.response.Response;
import com.example.lab_1.exceptions.BadRequestException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleException(@NotNull BadRequestException e) {
        logger.error("ERROR CODE 400", e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<Object> handleException(@NotNull Exception e) {
        logger.error("ERROR CODE 500", e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
