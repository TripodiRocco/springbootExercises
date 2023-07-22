package com.firstTimeSpring.demo.ExerciseBeans;

import org.springframework.stereotype.Component;
import java.lang.String;


// 1. Recreate a RestaurantConfig in your code!

// 2. Then add 2 fields to restaurant config, whatever you want!
// 3. Try changing the values of the restaurant config when we invoke it via HTTP

@Component
public class ConfigurazioneRistorante {
    private String nameOfRestaurant = "RESTaurant";
    private boolean isANewOpening = true;

    public ConfigurazioneRistorante() {

    }

    public String getNameOfRestaurant() {
        return nameOfRestaurant;
    }

    public void setNameOfRestaurant(String nameOfRestaurant) {
        this.nameOfRestaurant = nameOfRestaurant;
    }

    public boolean isANewOpening() {
        return isANewOpening;
    }

    public void setANewOpening(boolean ANewOpening) {
        isANewOpening = ANewOpening;
    }

}
