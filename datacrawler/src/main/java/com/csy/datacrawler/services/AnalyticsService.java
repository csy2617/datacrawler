package com.csy.datacrawler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public AnalyticsService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishGreetingAnalytics(String userId, String greetingType) {
        String message = String.format("User: %s, Greeting Type: %s, Timestamp: %s", userId, greetingType, System.currentTimeMillis());
        kafkaTemplate.send("greeting-analytics", message);
    }
}
