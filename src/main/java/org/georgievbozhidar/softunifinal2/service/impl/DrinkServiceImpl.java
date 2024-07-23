package org.georgievbozhidar.softunifinal2.service.impl;

import org.georgievbozhidar.softunifinal2.entity.dto.CreateDrinkDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Drink;
import org.georgievbozhidar.softunifinal2.repository.DrinkRepository;
import org.georgievbozhidar.softunifinal2.service.DrinkService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DrinkServiceImpl implements DrinkService {
    private final ModelMapper modelMapper;
    private final DrinkRepository drinkRepository;

    public DrinkServiceImpl(ModelMapper modelMapper, DrinkRepository drinkRepository) {
        this.modelMapper = modelMapper;
        this.drinkRepository = drinkRepository;
    }

    @Override
    public Drink createDrink(CreateDrinkDTO createDrinkDTO) {
        Drink drink = modelMapper.map(createDrinkDTO, Drink.class);
        drinkRepository.save(drink);
        return drink;
    }

    @Override
    public void deleteDrinkById(Long id) {
        Optional<Drink> optDrink = drinkRepository.findById(id);
        if (optDrink.isEmpty()){
            return;
        }

        drinkRepository.delete(optDrink.get());
    }

    @Override
    public Drink getDrinkById(Long id) {
       Optional<Drink> optDrink = drinkRepository.findById(id);
        return optDrink.orElse(null);

    }
}
