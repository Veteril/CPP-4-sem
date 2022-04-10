package com.example.lab_1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.lab_1.controller.CalculationController;
import com.example.lab_1.exceptions.BadRequestException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Lab1ApplicationTests {

    private final CalculationController control = new CalculationController();
    @Test
    void test() throws BadRequestException {
        var result = control.calculate(5, 2);
        var expected = 20.933333333333334;
        assertEquals(expected, result);
    }
}
