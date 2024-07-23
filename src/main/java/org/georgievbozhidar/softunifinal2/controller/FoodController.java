package org.georgievbozhidar.softunifinal2.controller;

import jakarta.validation.Valid;
import org.georgievbozhidar.softunifinal2.entity.dto.CreateDrinkDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.CreateFoodDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Drink;
import org.georgievbozhidar.softunifinal2.entity.model.Food;
import org.georgievbozhidar.softunifinal2.service.DrinkService;
import org.georgievbozhidar.softunifinal2.service.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/food/{id}")
    public ResponseEntity<Food> getFood(@PathVariable Long id) {
        Food food = foodService.getFoodById(id);
        if (food == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    @PostMapping("/food")
    public ResponseEntity<Food> createFood(@Valid CreateFoodDTO createFoodDTO){
        Food food = foodService.createFood(createFoodDTO);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

}
