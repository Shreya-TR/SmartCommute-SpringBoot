package com.smartcommute.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "*") // ✅ Enables access from mobile/web frontend
@RestController
public class PingController {

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("SmartCommute backend is running!");
    }
}