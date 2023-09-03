package com.firstTimeSpring.demo.Exercise6.Entities;

import jakarta.persistence.*;

@Entity
@Table
public class PiattoInvernale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private boolean isWinterMeal;

    public PiattoInvernale(long id, String name, String description, double price, boolean isWinterMeal) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isWinterMeal = isWinterMeal;
    }

    public PiattoInvernale(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isWinterMeal() {
        return isWinterMeal;
    }

    public void setWinterMeal(boolean winterMeal) {
        isWinterMeal = winterMeal;
    }
}
