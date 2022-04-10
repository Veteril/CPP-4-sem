package com.example.lab_1.result;

import com.example.lab_1.cache.SpringConfig;
import com.example.lab_1.cache.ProgramCache;
import com.example.lab_1.logger.MyLogger;
import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.Nullable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

    public void checkOrCalculate() {

        Double temp = programCache.find(input);
        if (temp != null) {
            MyLogger.log(Level.WARN, "Value found in cache!");
            setInfo(temp);
            return;
        }

        temp = input.getRadius() * input.getRadius()  * input.getHeight() * 3.14;
        setInfo(temp);
        programCache.add(input, root);
    }

    public Double getInfo() {
        return root;
    }
    public void setInfo(@Nullable Double root) {
        this.root = root;
    }
}
