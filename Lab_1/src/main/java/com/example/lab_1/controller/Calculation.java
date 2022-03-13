package com.example.lab_1.controller;

import com.example.lab_1.exeptions.ServiceExeption;
import com.example.lab_1.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculation {
    @GetMapping(value = "/volume")
    public Response calculate (@RequestParam(value = "h", defaultValue = "0") String h,
                               @RequestParam(value = "r", defaultValue = "0") String r) throws ServiceExeption{
        double radius;
        double height;
        if (h.matches("((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+") &&
                r.matches("((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+")) {
            radius = Double.parseDouble(r);
            height = Double.parseDouble(h);
            if (radius < 0 || height < 0) {
                throw new ServiceExeption("Wrong value...");
            }
        }
        else {
            throw new ServiceExeption("Wrong value...");
        }
        double temp = 3.14 * Math.pow(radius,2) * height / 3;
        return new Response(temp, "OK");
    }
}
