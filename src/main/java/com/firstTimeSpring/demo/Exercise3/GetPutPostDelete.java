package com.firstTimeSpring.demo.Exercise3;

import com.firstTimeSpring.demo.Exercise2.Meal;
import com.firstTimeSpring.demo.Exercise4.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



// Exercise 1: Create a PutMapping to add a new meal

// 1 - Create a new endpoint "/meal" using the @PostMapping annotation.
// 2 - In the method, add a RequestBody for the new Meal object.
// 3 - Add the new meal to the list of meals.

@RestController
public class GetPutPostDelete {

    List<Meal> piatti = Arrays.asList(
            new Meal("Spaghetti alla carbonara", "Uova, guanciale, formaggio pecorino", 8.00),
            new Meal("Spaghetti alla norma", "Sugo di pomodoro, melanzane, ricotta, basilico", 7.00),
            new Meal("Spaghetti alla bolognese", "Sugo di pomodoro, ragù di carne, parmigiano", 8.00),
            new Meal("Spaghetti alle vongole", "Vongole veraci, pomodorino, vino bianco, aglio", 9.00),
            new Meal("Spaghetti alla siciliana", "Melanzane fritte, pomodoro, ricotta salata", 7.00)
    );


    // Trasformazione da Arrays.asList ad ArrayList per attuare la richiesta PUT e le altre richieste e aggiungere nuovi piatti, in quanto la lista di prima è immutabile.
    List<Meal> nuovaListaPiatti = new ArrayList<>(piatti);

    @GetMapping(value = "/get/meals")
    public ResponseEntity<List<Meal>> ottieniListaPiatti(){
        return ResponseEntity.ok(nuovaListaPiatti);
    }

    @org.springframework.web.bind.annotation.PutMapping(value = "/meal")
    public ResponseEntity<String> aggiungiPiatto(@RequestBody Meal meal){
        this.nuovaListaPiatti.add(meal);
        return ResponseEntity.ok("Piatto aggiunto!");
    }



    // Exercise 2: Create a PostMapping to update a meal by name

    // 1 - Create a new endpoint "/meal/{name}" using the @PutMapping annotation.
    // 2 - In the method, add a PathVariable for the name and a RequestBody for the updated Meal object.
    // 3 - Update the meal with the corresponding name using the information from the RequestBody.

    @PostMapping(value = "/meal/{name}")
    public ResponseEntity<String> aggiornaNomePiatto(@PathVariable String name, @RequestBody Meal meal){
        this.nuovaListaPiatti.removeIf(piatto -> piatto.getName().equals(name));
        this.nuovaListaPiatti.add(meal);
        return ResponseEntity.ok("Nome del piatto aggiornato!");
    }



    // Exercise 3: Create a DeleteMapping to delete a meal by name

    // 1 - Create a new endpoint "/meal/{name}" using the @DeleteMapping annotation.
    // 2 - In the method, add a PathVariable for the name.
    // 3 - Delete the meal with the corresponding name.

    @DeleteMapping(value = "/meal/{name}")
    public ResponseEntity<String> eliminaNomePiatto(@PathVariable String name){
        this.nuovaListaPiatti.removeIf(piatto -> piatto.getName().equals(name));
        return ResponseEntity.ok("Nome del piatto eliminato!");
    }



    // Exercise 4: Create a DeleteMapping to delete all meals above a certain price

    // 1 - Create a new endpoint "/meal/price/{price}" using the @DeleteMapping annotation.
    // 2 - In the method, add a PathVariable for the price.
    // 3 - Delete all meals with a price above the price from the PathVariable.

    @DeleteMapping(value = "/meal/price/{price}")
    public ResponseEntity<String> eliminaAlcuniPiatti(@PathVariable double price){
        for (Meal meal : nuovaListaPiatti){
          if (meal.getPrice() >= price){
              nuovaListaPiatti.remove(0);
              nuovaListaPiatti.remove(1);
              nuovaListaPiatti.remove(1);
          }

        }
        return ResponseEntity.ok("I piatti sono stati eliminati!");
    }



    // Exercise 5: Create a PutMapping to update the price of a meal by name

    // 1 - Create a new endpoint "/meal/{name}/price" using the @PutMapping annotation.
    // 2 - In the method, add a PathVariable for the name and a RequestBody for the updated price.
    // 3 - Update the price of the meal with the corresponding name using the information from the RequestBody.

    @PutMapping(value = "/meal/{name}/price")
    public ResponseEntity<String> aggiornaPrezzoPiattoSpecifico(@PathVariable String name, @RequestBody double price){
        for (Meal meal : nuovaListaPiatti){
            if (meal.getName().equals(name) && meal.getPrice() != price){
                meal.setPrice(price);
                return ResponseEntity.ok("Ecco il nuovo prezzo del piatto " + name + " aggiornato a" + price);
            } else {
                return ResponseEntity.badRequest().body("Piatto non trovato");
            }
        }
        return ResponseEntity.ok("Ecco il nuovo prezzo del piatto " + name + " aggiornato a" + price);
    }

}
