package com.firstTimeSpring.demo.Exercise5.service;

import com.firstTimeSpring.demo.Exercise5.entities.Ingredient;
import com.firstTimeSpring.demo.Exercise5.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientService {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }



    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Ingredient findById(Long id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        return ingredient.orElse(null);
    }

    public Ingredient update(Ingredient ingredient) {
        Optional<Ingredient> ingredienteEsistente = ingredientRepository.findById(ingredient.getId());
        if (ingredienteEsistente.isPresent()) {
            return ingredientRepository.save(ingredient);
        }
        return null;
    }

    public void delete(Long id) {
        ingredientRepository.deleteById(id);
    }

}
