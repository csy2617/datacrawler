package com.csy.datacrawler.services;

import org.springframework.stereotype.Component;

@Component
public class RegularGreetingStrategyy implements GreetingStrategy {
    @Override
    public String generateGreeting(String name) {
        return "Hello, " + name + "!";
    }
}
