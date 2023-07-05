package com.firstTimeSpring.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// Exercise 3: Create a new class with a GetMapping that returns a ResponseEntity annotation
// 1 - Annotate a new class with the @RestController annotation.
// 2 - Create a new endpoint "/info" using the @GetMapping annotation.
// 3 - In the method, return a ResponseEntity with 200 OK
@RestController
public class Exercise3 {
    @GetMapping(value = "/info")
    public ResponseEntity<String> info(){
        return ResponseEntity.ok("Ma come funziona questo Spring?!");
    }

}
