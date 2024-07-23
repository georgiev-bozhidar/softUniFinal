package org.georgievbozhidar.softunifinal2.service;

import org.georgievbozhidar.softunifinal2.entity.dto.CreateFoodDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Food;

public interface FoodService {
    Food createFood(CreateFoodDTO createFoodDTO);
    void deleteFoodById(Long id);

    Food getFoodById(Long id);
}
