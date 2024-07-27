package org.georgievbozhidar.softunifinal2.service;

import org.georgievbozhidar.softunifinal2.entity.dto.DrinkDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateDrinkDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.update.UpdateDrinkDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Drink;

public interface DrinkService {
    public Drink findByName(String name);
    public DrinkDTO getById(Long id);
    public DrinkDTO getByName(String name);

    public DrinkDTO createDrink(CreateDrinkDTO createDrinkDTO);

    public DrinkDTO updateDrink(Long id, UpdateDrinkDTO updateDrinkDTO);

    public void deleteById(Long id);
}
