package org.georgievbozhidar.softunifinal2.controller;

import jakarta.validation.Valid;
import org.georgievbozhidar.softunifinal2.entity.dto.DrinkDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateDrinkDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.update.UpdateDrinkDTO;
import org.georgievbozhidar.softunifinal2.service.DrinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/location/{locationId}/drink")
public class DrinkController {
    private final DrinkService drinkService;

    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @PostMapping
    public String createDrink(@PathVariable("locationId") Long locationId, @Valid CreateDrinkDTO createDrinkDTO){
        drinkService.createDrink(createDrinkDTO);
        return "redirect:/location/" + locationId;
    }

    @PatchMapping("/{id}")
    public String updateDrink(@PathVariable("locationId") Long locationId, @PathVariable Long id, @RequestBody @Valid UpdateDrinkDTO updateDrinkDTO) {
        drinkService.updateDrink(id, updateDrinkDTO) ;
        return "redirect:/location/" + locationId;
    }

    @DeleteMapping("/{id}")
    public String deleteDrink(@PathVariable("locationId") Long locationId, @PathVariable Long id){
        drinkService.deleteById(id);
        return "redirect:/location/" + locationId;
    }
}
