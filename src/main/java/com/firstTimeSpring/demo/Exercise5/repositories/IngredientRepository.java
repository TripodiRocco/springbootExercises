package com.firstTimeSpring.demo.Exercise5.repositories;

import com.firstTimeSpring.demo.Exercise5.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
