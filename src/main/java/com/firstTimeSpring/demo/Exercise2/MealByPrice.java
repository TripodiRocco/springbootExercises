package com.firstTimeSpring.demo.Exercise2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



// Exercise 4: Create a GetMapping that returns a meal by price range
// 1 - Annotate a new class with the @RestController annotation.
// 2 - Create a new endpoint "/meal/price" using the @GetMapping annotation.
// 3 - In the method, add two query parameters "min" and "max" using the @RequestParam annotation.
// 4 - Return a list of Meal objects with prices within the specified range.

@RestController
public class MealByPrice {

    ListOfMeal listOfMeal = new ListOfMeal();

    @GetMapping(value = "/meal/price")
    public List<Meal> prezzoPasto(
            @RequestParam("min") double min,
            @RequestParam("max") double max){
        for (Meal meal : listOfMeal.ritornaListaPiatti()){
            if (meal.getPrice() >= min && meal.getPrice() <= max){
                return listOfMeal.ritornaListaPiatti();
            }
        }
        return listOfMeal.ritornaListaPiatti();
    }

}
