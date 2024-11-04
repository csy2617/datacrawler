package com.csy.datacrawler.repositories;

import com.csy.datacrawler.entities.Greeting;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepositories extends JpaRepository<Greeting, Long> {
    // No additional methods are needed, as JpaRepository provides findAll() by default
    Optional<Greeting> findByName(String name);
}
