package com.firstTimeSpring.demo.Repositories;

import com.firstTimeSpring.demo.Exercise2.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    // Fare queries riguardo lezione su Where in Hibernate?

    // Create a query method that finds all meals
}
