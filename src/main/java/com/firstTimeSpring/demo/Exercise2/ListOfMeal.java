package com.firstTimeSpring.demo.Exercise2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;



// Exercise 1: Create a GetMapping that returns a list of meals
// 1 - Annotate a new class with the @RestController annotation.
// 2 - Create a new endpoint "/meals" using the @GetMapping annotation.
// 3 - In the method, return a list of Meal objects.

@RestController
public class ListOfMeal {
    List<Meal> piatti = Arrays.asList(
            new Meal("Spaghetti alla carbonara", "Uova, guanciale, formaggio pecorino", 8.00),
            new Meal("Spaghetti alla norma", "Sugo di pomodoro, melanzane, ricotta, basilico", 7.00),
            new Meal("Spaghetti alla bolognese", "Sugo di pomodoro, ragù di carne, parmigiano", 8.00),
            new Meal("Spaghetti alle vongole", "Vongole veraci, pomodorino, vino bianco, aglio", 9.00),
            new Meal("Spaghetti alla siciliana", "Melanzane fritte, pomodoro, ricotta salata", 7.00)
    );


    @GetMapping(value = "/meals")
    public List<Meal> ritornaListaPiatti(){
        return piatti;
    }



}
