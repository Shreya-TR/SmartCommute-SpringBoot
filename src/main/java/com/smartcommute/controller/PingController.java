package com.smartcommute.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("SmartCommute backend is running!");
    }
}