package com.example.lab_1.controller;

import com.example.lab_1.exceptions.BadRequestException;
import com.example.lab_1.result.logger.MyLogger;
import org.apache.logging.log4j.Level;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.example.lab_1.result.Input;
import com.example.lab_1.result.CalculateData;
import com.example.lab_1.cache.ProgramCache;


@RestController
public class CalculationController {
    CalculateData data = new CalculateData();
    Counter counter = new Counter();
    @GetMapping(value = "/volume")
    public ResponseEntity<Object> calculate (@RequestParam(value = "h", defaultValue = "0") double h,
                                             @RequestParam(value = "r", defaultValue = "0") double r) throws  BadRequestException {
        counter.increaseCounter();
        if (r < 0 && h < 0)
            throw new BadRequestException("ERROR 400, BAD REQUEST, invalid h and r values...");
        if (r < 0)
            throw new BadRequestException("ERROR 400, BAD REQUEST, invalid r value...");
        if (h < 0)
            throw new BadRequestException("ERROR 400, BAD REQUEST, invalid h value...");

        data.changeInfo(new Input(h,r));
        data.checkOrCalculate();

       return new ResponseEntity<>(data.getInfo(), HttpStatus.OK);
    }

    @GetMapping("/cache")
    public ResponseEntity<String> printCache() {
        return new ResponseEntity<>(ProgramCache.getCache(), HttpStatus.OK);
    }


    /*@PostMapping(value = "/calculation", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity alternativeCalculation(@RequestBody String[] array) {
        return new ResponseEntity<>(data.averageOfPositive(array), HttpStatus.OK);
    }*/

    @PostMapping(value = "/calculation",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity filter(@RequestBody String[] arr) {
        MyLogger.log(Level.INFO, "Input reached");
        return ResponseEntity.ok(data.FilterData(arr));
    }
}
