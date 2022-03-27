package com.example.lab_1.calculations;

import com.example.lab_1.SpringConfig;
import com.example.lab_1.cache.Cache;
import com.example.lab_1.logger.ProgramLogger;
import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.Nullable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Solution {

    private final Cache cache;

    private final Parameters parameters;

    private Integer root;

    public Solution(Parameters params) {
        var context = new AnnotationConfigApplicationContext(SpringConfig.class);
        cache = context.getBean("cache", Cache.class);
        context.close();

        this.parameters = params;
    }

    public void calculateRoot() {
        // Trying to find root in cache
        var temp = cache.find(parameters);
        if (temp != null) {
            ProgramLogger.log(Level.WARN, "Value found in cache!");
            setRoot(temp);

            return;
        }

        // If not found

        temp = parameters.getSecondValue() * parameters.getSecondValue()  * parameters.getFirstValue();
        setRoot(temp);
        // Adding { inputParams, root } to cache
        cache.add(parameters, root);
    }

    public Integer getRoot() {
        return root;
    }

    public void setRoot(@Nullable Integer root) {
        this.root = root;
    }

}
