package com.example.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BackendController {

    @GetMapping("/")
    public String home() {

        return "Java Backend is running";
    }

    @GetMapping("/api")
    public Map<String, String> api() {

        Map<String, String> response = new HashMap<>();

        response.put("message", "Java Backend is working");
        response.put("database", "Not connected yet");
        response.put("author", "Priyanka");

        return response;
    }
}