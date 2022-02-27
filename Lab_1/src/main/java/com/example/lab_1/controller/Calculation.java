package com.example.lab_1.controller;

import com.example.lab_1.entities.Volume;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculation {
    @GetMapping("/volume")
    Volume calculate (@RequestParam(value = "h", defaultValue = "0") Double h,
                  @RequestParam(value = "r", defaultValue = "0") Double r) {
        return new Volume(3.14 * Math.pow(r,2) * h / 3);
    }
}
