package org.georgievbozhidar.softunifinal2.service;

import org.georgievbozhidar.softunifinal2.entity.dto.FoodDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateFoodDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.update.UpdateFoodDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Food;

public interface FoodService {
    public Food findByName(String name);
    public FoodDTO getById(Long id);
    public FoodDTO getByName(String name);

    public FoodDTO createFood(CreateFoodDTO createFoodDTO);

    public FoodDTO updateFood(Long id, UpdateFoodDTO updateFoodDTO);

    public void deleteById(Long id);
}
