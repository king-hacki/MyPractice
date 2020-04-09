package com.example.jwt_token.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Test {

    @GetMapping(value = "/test")
    public ResponseEntity<?> test () {
        return ResponseEntity.ok("test successfully");
    }

}
