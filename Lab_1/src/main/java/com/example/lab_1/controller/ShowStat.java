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
//@RequestMapping("/stats")
class ShowStat {

    public final Provide statsProvider = new Provide();
    public ShowStat() {

    }


    @GetMapping("/stats")
    public ResponseEntity<Stat>receiveStat() {
        statsProvider.calculate(statsProvider.totalReq,statsProvider.wrongReq);
        return new ResponseEntity<>(statsProvider.getStats(), HttpStatus.OK);
    }
}

