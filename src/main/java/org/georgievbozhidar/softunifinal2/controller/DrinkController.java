package org.georgievbozhidar.softunifinal2.controller;

import jakarta.validation.Valid;
import org.georgievbozhidar.softunifinal2.entity.dto.CreateDrinkDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Drink;
import org.georgievbozhidar.softunifinal2.service.DrinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class DrinkController {
    private final DrinkService drinkService;

    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping("/drink/{id}")
    public ResponseEntity<Drink> getDrink(@PathVariable Long id) {
        Drink drink = drinkService.getDrinkById(id);
        if (drink == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(drink, HttpStatus.OK);
    }

    @PostMapping("/drink")
    public ResponseEntity<Drink> createDrink(@Valid CreateDrinkDTO createDrinkDTO){
        Drink drink = drinkService.createDrink(createDrinkDTO);
        return new ResponseEntity<>(drink, HttpStatus.OK);
    }
}
