package com.example.lab_1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.lab_1.controller.Calculation;
import com.example.lab_1.exeptions.ServiceExeption;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Lab1ApplicationTests {

    private final Calculation calculationController = new Calculation();
    @Test
    void testCalculateResultPlus_10() throws ServiceExeption {
        double result = calculationController.calculate("5", "2");
        double expected = 20.933333333333334;
        assertEquals(expected, result);
    }

    @Test
    void testCalculateResultPlus_1() throws ServiceExeption {
        double result = calculationController.calculate("5", "2");
        double expected = 20.933333333333334;

        assertEquals(expected, result);
    }

    @Test
    void testCalculateResultMinus_1() throws ServiceExeption {
        double result = calculationController.calculate("5", "2");
        double expected = 20.933333333333334;

        assertEquals(expected, result);
    }

    @Test
    void testCalculateResultMinus_10() throws ServiceExeption {
        double result = calculationController.calculate("5", "2");
        double expected = 20.933333333333334;

        assertEquals(expected, result);
    }
}
