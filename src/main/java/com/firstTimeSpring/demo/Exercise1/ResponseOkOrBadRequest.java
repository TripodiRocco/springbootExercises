package com.firstTimeSpring.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


// Exercise 4: Create a GetMapping that returns 400 - Bad request or 200 - OK based on a random boolean
// 1 - Annotate a new class with the @RestController annotation.
// 2 - Create a new endpoint "/random" using the @GetMapping annotation.
// 3 - In the method, return a ResponseEntity with 200 OK or 400 Bad Request based on the result of new Random().nextBoolean()
@RestController
public class Controller3 {

    @GetMapping(value = "/random")
    public ResponseEntity<Boolean> saraVeroOppureFalso(){
        boolean trueOrFalse = new Random().nextBoolean();
        if (trueOrFalse == true){
            return ResponseEntity.ok(true);
        }else {
            return ResponseEntity.badRequest().body(false);
        }
    }

}
