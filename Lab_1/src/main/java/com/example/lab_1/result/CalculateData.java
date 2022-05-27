package com.example.lab_1.result;

import com.example.lab_1.cache.SpringConfig;
import com.example.lab_1.cache.ProgramCache;
import com.example.lab_1.result.logger.MyLogger;
import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.Nullable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CalculateData {

    private final ProgramCache programCache;

    private Input input;

    private Double root;

    public CalculateData() {
        var context = new AnnotationConfigApplicationContext(SpringConfig.class);
        programCache = context.getBean("cache", ProgramCache.class);
        context.close();
    }

    public void changeInfo(Input params) {
        this.input = params;
    }

    public Integer checkOrCalculate() {

        Double temp = programCache.find(input);
        temp = input.getRadius() * input.getRadius()  * input.getHeight() * 3.14;
        setInfo(temp);
        programCache.add(input, root);
        int value = temp.intValue();
        return value;
    }

    public Double getInfo() {
        return root;
    }
    public void setInfo(@Nullable Double root) {
        this.root = root;
    }


    public static int[] FilterData (String[] arr){
        MyLogger.log(Level.INFO, "Filtering");
        IntStream stream = Stream.of(arr).mapToInt(Integer::parseInt);
        return stream.filter(i -> i < 100).toArray();
    }

}
