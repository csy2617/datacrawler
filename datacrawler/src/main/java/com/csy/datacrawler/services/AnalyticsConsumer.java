package com.csy.datacrawler.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsConsumer {

    @KafkaListener(topics = "greeting-analytics", groupId = "analytics-group")
    public void consume(String message) {
        // Process the analytics message (e.g., store in a database, log it, etc.)
        System.out.println("Received analytics message: " + message);
    }
}
