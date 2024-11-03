// GreetingService.java
package com.csy.datacrawler.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    private final Map<String, GreetingStrategy> greetingStrategies;

    @Autowired
    public GreetingService(Map<String, GreetingStrategy> greetingStrategies) {
        this.greetingStrategies = greetingStrategies;
    }

    public String getGreeting(String name, String greetingType) {
        GreetingStrategy strategy = greetingStrategies.getOrDefault(greetingType, greetingStrategies.get("regularGreetingStrategyy"));
        return strategy.generateGreeting(name);
    }
 
}