package com.example.lab_1;

import com.example.lab_1.cache.Cache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig {

    @Bean("cache")
    @Scope(value = "singleton")
    Cache cache() {
        return new Cache();
    }

}