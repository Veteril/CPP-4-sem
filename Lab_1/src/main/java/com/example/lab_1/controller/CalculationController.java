package com.example.lab_1.controller;

import com.example.lab_1.exceptions.InternalServerException;
import com.example.lab_1.exceptions.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculationController {
    @GetMapping(value = "/volume")
    public double calculate (@RequestParam(value = "h", defaultValue = "0") double h,
                             @RequestParam(value = "r", defaultValue = "0") double r) throws  BadRequestException {
        if (r < 0 && h < 0)
            throw new BadRequestException("ERROR 400, BAD REQUEST, invalid h and r values...");
        if (r < 0)
            throw new BadRequestException("ERROR 400, BAD REQUEST, invalid r value...");
        if (h < 0)
            throw new BadRequestException("ERROR 400, BAD REQUEST, invalid h value...");
        double temp = 3.14 * Math.pow(r,2) * h / 3;
        return temp;
    }
}
