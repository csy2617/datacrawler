package com.csy.datacrawler.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "greetings")
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private LocalDateTime greetingTime;

    public Greeting() {
        // Default constructor for JPA
    }

    public Greeting(Long id, String name, String type, LocalDateTime greetingTime) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.greetingTime = greetingTime;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getGreetingTime() {
        return greetingTime;
    }

    public void setGreetingTime(LocalDateTime greetingTime) {
        this.greetingTime = greetingTime;
    }
}
