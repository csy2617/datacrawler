// GreetingService.java
package com.csy.datacrawler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final GreetingStrategy greetingStrategy;

    @Autowired
    public GreetingService(@Qualifier("regularGreetingStrategyy") GreetingStrategy greetingStrategy) {
        this.greetingStrategy = greetingStrategy;
    }

    public String getGreeting(String name) {
        return greetingStrategy.generateGreeting(name);
    }
}