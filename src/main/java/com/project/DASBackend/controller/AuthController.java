package com.project.DASBackend.controller;

import com.project.DASBackend.dto.AccountDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestHeader("Authorization") String token) {
        // Handle login logic, e.g., verify the token and return user details
        return ResponseEntity.ok("Login successful");
    }
}