package com.firstTimeSpring.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {

    // Exercise 1: Create a GetMapping that returns a basic "string" as a response
    @GetMapping(value = "/")
    public String testString() {
        return "string";
    }

    // 1 - Create a new endpoint "/hello" using the @GetMapping annotation.
    // 2 - In the method, return a simple string such as "Hello World!".
    @GetMapping(value = "/hello")
    public String testHelloWorld() {
        return "Hello World";
    }

    // Exercise 2: Create a GetMapping that returns a ResponseEntity as a response
    // 1 - Create a new endpoint "/greeting" using the @GetMapping annotation.
    // 2 - In the method, return a ResponseEntity object with a string message such as "Good Afternoon!".
    // 3 - You can also set the HTTP status code in the ResponseEntity, such as "200 OK".
    @GetMapping(value = "/greeting")
    public ResponseEntity<String> primoResponso(){
        return ResponseEntity.status(200).body("Good Afternoon!");
    }

}
