package org.georgievbozhidar.softunifinal2.service;

import org.georgievbozhidar.softunifinal2.entity.dto.CreateFoodDTO;

public interface FoodService {
    void createFood(CreateFoodDTO createFoodDTO);
    void deleteFoodById(Long id);
}
