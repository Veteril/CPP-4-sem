package com.example.lab_1.controller;

import com.example.lab_1.logger.MyLogger;
import org.apache.logging.log4j.Level;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Counter {

    static int counter = 0;

    Counter() {}

    synchronized public void increaseCounter() {
        counter++;
        MyLogger.log(Level.INFO, "Controller has been called for " +counter+ " times");
    }

    @GetMapping("/calls")
    synchronized  public String showCalls() {
        return "Number of calls: "+counter;
    }


}
