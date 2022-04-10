package com.example.lab_1.cache;

import com.example.lab_1.cache.ProgramCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig {

    @Bean("cache")
    @Scope(value = "singleton")
    ProgramCache cache() {
        return new ProgramCache();
    }

}