package com.example.lab_1.controller;

import com.example.lab_1.result.Provide;
import com.example.lab_1.result.Input;
import com.example.lab_1.result.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/stats")
public class ShowStat {
    private final Provide statsProvider;

    @Autowired
    public ShowStat(Provide statsProvider) {
        this.statsProvider = statsProvider;
    }

    @GetMapping
    public ResponseEntity<Stat>receiveStat() {
        statsProvider.calculate();
        return new ResponseEntity<>(statsProvider.getStats(), HttpStatus.OK);
    }
}
