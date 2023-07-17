package com.firstTimeSpring.demo.Exercise2;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



// Exercise 2: Create a GetMapping that returns a meal by name
// 1 - Annotate a new class with the @RestController annotation.
// 2 - Create a new endpoint "/meal/{name}" using the @GetMapping annotation.
// 3 - In the method, add a query parameter "name" using the @PathVariable annotation.
// 4 - Return a Meal object with the corresponding name.


@RestController
public class MealByName {
    ListOfMeal listOfMeal = new ListOfMeal();

    @GetMapping(value = "/meal/{name}")
    public ResponseEntity<?> nomePiatto(@PathVariable String name){
        for (Meal meal : listOfMeal.ritornaListaPiatti()){
            if (meal.getName().equals(name)){
                return ResponseEntity.ok(meal.getName());
            } else {
                return ResponseEntity.status(404).body("nome non trovato");
            }
        }
    return ResponseEntity.ok(name);
    }

}