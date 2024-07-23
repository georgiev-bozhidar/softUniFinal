package org.georgievbozhidar.softunifinal2.service;

import org.georgievbozhidar.softunifinal2.entity.dto.CreateDrinkDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Drink;

public interface DrinkService {
    Drink createDrink(CreateDrinkDTO createDrinkDTO);
    void deleteDrinkById(Long id);

    Drink getDrinkById(Long id);
}
