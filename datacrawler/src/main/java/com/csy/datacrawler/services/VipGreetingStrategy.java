// VipGreetingStrategy.java
package com.csy.datacrawler.services;

import org.springframework.stereotype.Component;

@Component
public class VipGreetingStrategy implements GreetingStrategy {

    @Override
    public String generateGreeting(String name) {
        return "Welcome, esteemed VIP " + name + "!";
    }
}
