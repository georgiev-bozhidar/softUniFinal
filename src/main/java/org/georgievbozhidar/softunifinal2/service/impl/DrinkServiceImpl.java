package org.georgievbozhidar.softunifinal2.service.impl;

import org.georgievbozhidar.softunifinal2.entity.dto.DrinkDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateDrinkDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.update.UpdateDrinkDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Drink;
import org.georgievbozhidar.softunifinal2.exception.DrinkNotFoundException;
import org.georgievbozhidar.softunifinal2.repository.DrinkRepository;
import org.georgievbozhidar.softunifinal2.service.DrinkService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Service
public class DrinkServiceImpl implements DrinkService {
    private final ModelMapper modelMapper;
    private final DrinkRepository drinkRepository;
    private final RestClient restClient;

    public DrinkServiceImpl(ModelMapper modelMapper, DrinkRepository drinkRepository, RestClient restClient) {
        this.modelMapper = modelMapper;
        this.drinkRepository = drinkRepository;
        this.restClient = restClient;
    }

    @Override
    public DrinkDTO getById(Long id) {
        return restClient.get().uri("/food/{id}", id).retrieve().body(DrinkDTO.class);
    }

    @Override
    public Drink findByName(String name) {
        Optional<Drink> optDrink = drinkRepository.findByName(name);
        if (optDrink.isEmpty()) {
            throw new DrinkNotFoundException();
        }

        return optDrink.get();
    }

    @Override
    public DrinkDTO getByName(String name) {
        Drink drink = findByName(name);
        return restClient.get().uri("/drink/{id}", drink.getId()).retrieve().body(DrinkDTO.class);
    }

    @Override
    public DrinkDTO createDrink(CreateDrinkDTO createDrinkDTO) {
        return restClient.post().uri("/drink", createDrinkDTO).retrieve().body(DrinkDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        restClient.delete().uri("/drink/{id}", id);
    }

    @Override
    public DrinkDTO updateDrink(Long id, UpdateDrinkDTO updateDrinkDTO) {
        return restClient.put().uri("/drink/{id}", id).body(updateDrinkDTO).retrieve().body(DrinkDTO.class);
    }
}
