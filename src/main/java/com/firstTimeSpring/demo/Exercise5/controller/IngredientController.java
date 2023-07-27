package com.firstTimeSpring.demo.Exercise5.controller;

import com.firstTimeSpring.demo.Exercise5.entities.Ingredient;
import com.firstTimeSpring.demo.Exercise5.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ingrediente")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @PostMapping(value = "/crea")
    public void creaIngrediente(@RequestBody Ingredient ingredient){
        ingredientRepository.save(ingredient);
    }


    @GetMapping(value = "/ottieni")
    public Ingredient ottieniIngredienteDaId(@RequestParam long id){
        Optional<Ingredient> trovaIngrediente = ingredientRepository.findById(id);
        if (trovaIngrediente.isEmpty()){
            throw new IllegalArgumentException("Id inserito non esistente nel database!");
        }
        return trovaIngrediente.get();
    }


    @DeleteMapping(value = "/elimina/{id}")
    public void eliminaIngrediente(@PathVariable Long id, @RequestBody Ingredient ingredient){
        ingredientRepository.delete(ingredient);
            if (ingredient == null){
                throw new IllegalArgumentException("Non puoi eliminare l'ingrediente perchè non trovato!");
        }
    }


    @PutMapping(value = "/aggiorna/{id}")
    public ResponseEntity<Ingredient> aggiornaIngrediente(@PathVariable Long id, @RequestBody Ingredient ingredient){
        Optional<Ingredient> ingredienteEsistente = ingredientRepository.findById(id);
            if (ingredienteEsistente.isPresent()){
                ingredient = ingredienteEsistente.get();
                ingredient.setName(ingredient.getName());

                ingredientRepository.save(ingredient);

            }
            return ResponseEntity.status(200).body(ingredient);
    }

}
