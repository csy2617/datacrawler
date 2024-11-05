// GreetingService.java
package com.csy.datacrawler.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.csy.datacrawler.entities.Greeting;
import com.csy.datacrawler.repositories.GreetingRepositories;

@Service
public class GreetingService {
    private final Map<String, GreetingStrategy> greetingStrategies;
    private final GreetingRepositories greetingRepositories;
    private final AnalyticsService analyticsService;
    //private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GreetingService(Map<String, GreetingStrategy> greetingStrategies, GreetingRepositories greetingRepositories, AnalyticsService analyticsService) {
        this.greetingStrategies = greetingStrategies;
        this.greetingRepositories = greetingRepositories;
        this.analyticsService = analyticsService;
        //this.jdbcTemplate = jdbcTemplate;
    }

    public String getGreeting(String name, String greetingType) {
        GreetingStrategy strategy = greetingStrategies.getOrDefault(greetingType, greetingStrategies.get("regularGreetingStrategyy"));
        analyticsService.publishGreetingAnalytics(name, greetingType);
        return strategy.generateGreeting(name);
    }

    // public List<Map<String, Object>> getAllGreetingsResult() {
    //     String sql = "SELECT * FROM greetings";
    //     return jdbcTemplate.queryForList(sql);
    // }

    public List<Greeting> getAllGreetings() {
        return greetingRepositories.findAll();
    }

    public String getGreetingByName(String name) {
        Optional<Greeting> greetingOptional = greetingRepositories.findByName(name);
        if (greetingOptional.isPresent()) {
            Greeting greeting = greetingOptional.get();
            String greetingType = greeting.getType();
            GreetingStrategy strategy = greetingStrategies.getOrDefault(greetingType, greetingStrategies.get("regularGreetingStrategyy"));
            return strategy.generateGreeting(greeting.getName());
        } else {
            return "Greeting not found."; // Handle the case where no greeting is found
        }
    }

    
 
}