package com.example.springboot.Exercise2;


import com.example.springboot.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MealController {
    private List<Meal> chefsSpecials = Arrays.asList(
            new Meal("Carne", "Impanata con soia", 9.99),
            new Meal("Insalata", "Insalata con pomodoro e tonno", 5.99),
            new Meal("Pizza", "Peperoni e acciughe", 4.99),
            new Meal("Pizza", "Salsiccia e friarielli", 5.99),
            new Meal("Pizza", "Gorgonzola e noci", 6.99),
            new Meal("Pizza", "Marinara", 3.99),
            new Meal("Pizza", "Wiurstel e patatine", 5.99)
    );
    @GetMapping("/meals")
    public List<Meal> getAllMeals() {
        return chefsSpecials;
    }
    @GetMapping("/meal/{name}")
    public ResponseEntity<Meal> getMealByName(@PathVariable String name) {
        for (Meal meal : chefsSpecials) {
            if (meal.getName().equalsIgnoreCase(name)) {
                return ResponseEntity.ok(meal);
            }
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/meal/description-match/{phrase}")
    public ResponseEntity<Meal> getMealByDescription(@PathVariable("phrase") String phrase) {
        for (Meal meal : chefsSpecials) {
            if (meal.getDescription().equalsIgnoreCase(phrase)) {
                return ResponseEntity.ok(meal);
            }
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/meal/price")
    public List<Meal> getMealsByPriceRange(
            @RequestParam("min") double minPrice,
            @RequestParam("max") double maxPrice){
        List<Meal> mealsInRange = new ArrayList<>();
        for (Meal meal : chefsSpecials) {
            if (meal.getPrice() >= minPrice && meal.getPrice() <= maxPrice) {
                mealsInRange.add(meal);
            }
        }
        return mealsInRange;
    }
}
