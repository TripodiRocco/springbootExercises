package com.firstTimeSpring.demo.Exercise2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


// Exercise 3: Create a GetMapping that returns a meal by any word of description
// 1 - Annotate a new class with the @RestController annotation.
// 2 - Create a new endpoint "/meal/description-match/{phrase}" using the @GetMapping annotation
// 3 - In the method, add a query parameter "description" using the @PathVariable annotation.
// 4 - Return a Meal object with the corresponding description.

@RestController
public class MealByAnyWordsOfDescription {

    ListOfMeal listOfMeal = new ListOfMeal();
    @GetMapping(value = "/meal/description-match/{description}")
    public ResponseEntity<?> descrizionePasto(@PathVariable String description){
        for (Meal meal : listOfMeal.ritornaListaPiatti()){
            if (meal.getDescription().equals(description)){
                return ResponseEntity.ok(meal.getDescription());
            }
        }
        return ResponseEntity.badRequest().body("descrizione non corrispondente");
    }

}
