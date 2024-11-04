package com.csy.datacrawler.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.csy.datacrawler.entities.Greeting;
import com.csy.datacrawler.services.GreetingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "Hello World API", description = "Sample API to demonstrate Swagger")
@RequestMapping("/greetings")
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    @Operation(summary = "Say hello", description = "Returns a greeting message")
    public String getGreeting() {
        //return greetingService.getAllGreetings();
        //List greeting = new ArrayList();
       // greeting.add(new Greeting(1L, "hi"));
        return "Hi";
    }

    @GetMapping("/{name}")
    @Operation(summary = "Get a personalized greeting", description = "Returns a greeting based on the greeting type")
    public ResponseEntity<String> getGreeting(
            @PathVariable String name,
            @RequestParam(value = "type", defaultValue = "regularGreetingStrategyy") String greetingType) {
        
        String greetingMessage = greetingService.getGreeting(name, greetingType);
        return ResponseEntity.ok(greetingMessage);
    }

    @GetMapping("/all")
    @Operation(summary = "Retrieve all greetings", description = "Returns a list of all greetings")
    public List<Greeting> getAllGreetingsResult() {
        return greetingService.getAllGreetings();
    }

    @GetMapping("/message/{name}")
    @Operation(summary = "Get personalized greeting by name", description = "Returns a greeting message based on the name provided")
    public ResponseEntity<String> getGreetingByName(@PathVariable String name) {
    String greetingMessage = greetingService.getGreetingByName(name);
    return ResponseEntity.ok(greetingMessage);
}

}

