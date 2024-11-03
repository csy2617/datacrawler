// HolidayGreetingStrategy.java
package com.csy.datacrawler.services;

import org.springframework.stereotype.Component;

@Component
public class HolidayGreetingStrategy implements GreetingStrategy {

    @Override
    public String generateGreeting(String name) {
        return "Happy Holidays, " + name + "!";
    }
}
