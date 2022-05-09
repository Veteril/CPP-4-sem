package com.example.lab_1.cache;

import com.example.lab_1.result.Input;
import org.apache.logging.log4j.Level;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.example.lab_1.result.logger.MyLogger;

import java.util.HashMap;
import java.util.Map;

public class ProgramCache {

    private static final Map<Input, Double> hashMap = new HashMap<>();

    public void add(@NotNull Input params, @NotNull Double root) {
        if (!hashMap.containsKey(params)) {
            hashMap.put(params, root);
            MyLogger.log(Level.INFO, "Value " + params + "@" + root + " added to cache!");
        }
    }

    public @Nullable Double find(@NotNull Input params) {
        if (hashMap.containsKey(params))
            return hashMap.get(params);

        MyLogger.log(Level.WARN, "Value " + params + " was not found in cache!");
        return null;
    }

    public static @NotNull String getCache() {
        return ("Cache size:\n" + hashMap.size() + "\nCache:\n" + hashMap);
    }
}
