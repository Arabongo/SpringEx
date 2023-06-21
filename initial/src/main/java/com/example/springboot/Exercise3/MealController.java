package com.example.springboot.Exercise3;

import com.example.springboot.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class MealController {
    private List<Meal> meals = new ArrayList<>();
    //1)
    @PostMapping("/meal")
    public ResponseEntity<String> addMeal(@RequestBody Meal meal) {
        meals.add(meal);
        return ResponseEntity.ok("Meal added!");
    }
    //2)
    @PostMapping("/meal/{name}")
    public ResponseEntity<String> updateMealByName(@PathVariable String name, @RequestBody Meal updatedMeal) {
        for (Meal meal : meals) {
            if (meal.getName().equals(name)) {
                meal.setName(updatedMeal.getName());
                meal.setPrice(updatedMeal.getPrice());
                // Add other properties if needed

                return ResponseEntity.ok("Meal updated!");
            }
        }

        return ResponseEntity.notFound().build();
    }
    //3)
    @DeleteMapping("/meal/{name}")
    public ResponseEntity<String> deleteMeal(@PathVariable String name) {
        meals.removeIf(meal -> meal.getName().equals(name));
        return ResponseEntity.ok("Meal deleted!");
    }
    //4)
    @DeleteMapping("/meal/price/{price}")
    public ResponseEntity<String> deleteMealsAbovePrice(@PathVariable double price) {
        meals.removeIf(meal -> meal.getPrice() > price);
        return ResponseEntity.ok("Meals above price deleted!");
    }
    //5)
    @PutMapping("/meal/{name}/price")
    public ResponseEntity<String> updateMealPrice(@PathVariable String name, @RequestBody double updatedPrice) {
        for (Meal meal : meals) {
            if (meal.getName().equals(name)) {
                meal.setPrice(updatedPrice);
                return ResponseEntity.ok("Meal price updated!");
            }
        }

        return ResponseEntity.notFound().build();
    }
}
