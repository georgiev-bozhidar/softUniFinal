package org.georgievbozhidar.softunifinal2.controller;

import jakarta.validation.Valid;
import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateFoodDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.update.UpdateFoodDTO;
import org.georgievbozhidar.softunifinal2.service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/location/{locationId}/food")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    public String createFood(@PathVariable("locationId") Long locationId, @Valid CreateFoodDTO createFoodDTO){
        foodService.createFood(createFoodDTO);
        return "redirect:/location/" + locationId;
    }

    @PatchMapping("/{id}")
    public String updateFood(@PathVariable("locationId") Long locationId, @PathVariable Long id, @RequestBody @Valid UpdateFoodDTO updateFoodDTO) {
        return "redirect:/location/" + locationId;
    }

    @DeleteMapping("/{id}")
    public String deleteFood(@PathVariable("locationId") Long locationId, @PathVariable Long id){
        foodService.deleteById(id);
        return "redirect:/location/" + locationId;
    }

}
