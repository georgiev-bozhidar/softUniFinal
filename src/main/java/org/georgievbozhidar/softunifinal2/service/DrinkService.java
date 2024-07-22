package org.georgievbozhidar.softunifinal2.service;

import org.georgievbozhidar.softunifinal2.entity.dto.CreateDrinkDTO;

public interface DrinkService {
    void createDrink(CreateDrinkDTO createDrinkDTO);
    void deleteDrinkById(Long id);
}
