package com.example.lab_1;


import com.example.lab_1.controller.Counter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@SpringBootTest
class Lab1ApplicationTests {

    //    @Test
//
//    void test1() throws CalculationException {
//        Complex result = calculationController.complexCalculation("1", "0");
//        Complex expected=new Complex(1.0,1.5707963267948966);
//        assertEquals(expected, result);
//    }
    @Test
    void testIncrement() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Counter counterService = new Counter();
        IntStream.range(0, 10000).forEach(count -> executorService.execute(counterService::increaseCounter));

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        assertEquals(10000, counterService.retInt(), "Synchronization check");
    }
}
