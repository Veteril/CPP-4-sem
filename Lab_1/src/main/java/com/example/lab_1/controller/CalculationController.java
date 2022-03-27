package com.example.lab_1.controller;

import com.example.lab_1.exceptions.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.example.lab_1.calculations.Parameters;
import com.example.lab_1.calculations.Solution;
import com.example.lab_1.cache.Cache;

@RestController
public class CalculationController {
    @GetMapping(value = "/volume")
    public ResponseEntity<Object> calculate (@RequestParam(value = "h", defaultValue = "0") int h,
                                             @RequestParam(value = "r", defaultValue = "0") int r) throws  BadRequestException {
        if (r < 0 && h < 0)
            throw new BadRequestException("ERROR 400, BAD REQUEST, invalid h and r values...");
        if (r < 0)
            throw new BadRequestException("ERROR 400, BAD REQUEST, invalid r value...");
        if (h < 0)
            throw new BadRequestException("ERROR 400, BAD REQUEST, invalid h value...");

        var solution = new Solution(new Parameters(h,r));
        solution.calculateRoot();

       return new ResponseEntity<>(solution.getRoot(), HttpStatus.OK);
    }

    @GetMapping("/cache")
    public ResponseEntity<String> printCache() {
        return new ResponseEntity<>(Cache.getStaticStringCache(), HttpStatus.OK);
    }
}
