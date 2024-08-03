package com.crudbackend.crud.controller;

import com.crudbackend.crud.model.Food;
import com.crudbackend.crud.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
@CrossOrigin("http://localhost:4200/")
public class FoodController {
    @Autowired
    FoodService foodService;

    @PostMapping
    public ResponseEntity<Food> saveFood(@RequestBody Food food) {
        try {
            Food savedFood = foodService.save(food);
            return new ResponseEntity<>(savedFood, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Food>> getFoods() {
        return new ResponseEntity<>(foodService.getFoods(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getById(@PathVariable Long id) {
        Optional<Food> foodOptional = foodService.getById(id);
        return foodOptional.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Food> delete(@PathVariable Long id) {
        Optional<Food> food = foodService.getById(id);
        return food.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping
    public ResponseEntity<Food> updateFood(Food food){
        try {
            Food savedFood = foodService.update(food);
            return new ResponseEntity<>(savedFood, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
