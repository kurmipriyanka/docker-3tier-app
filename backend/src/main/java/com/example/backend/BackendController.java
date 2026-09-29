package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BackendController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String home() {
        return "Java Backend is running";
    }

    @GetMapping("/api")
    public Map<String, String> api() {

        Map<String, String> response = new HashMap<>();

        response.put("message", "Java Backend is working");
        response.put("author", "Priyanka");

        try {
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            response.put("database", "Connected to MySQL");
        } catch (Exception e) {
            response.put("database", "MySQL connection failed");
        }

        return response;
    }
}