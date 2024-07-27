package org.georgievbozhidar.softunifinal2.service.impl;

import org.georgievbozhidar.softunifinal2.entity.dto.DrinkDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.FoodDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateDrinkDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateFoodDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.update.UpdateFoodDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Drink;
import org.georgievbozhidar.softunifinal2.entity.model.Food;
import org.georgievbozhidar.softunifinal2.exception.DrinkNotFoundException;
import org.georgievbozhidar.softunifinal2.exception.FoodNotFoundException;
import org.georgievbozhidar.softunifinal2.repository.FoodRepository;
import org.georgievbozhidar.softunifinal2.service.FoodService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {
    private final ModelMapper modelMapper;
    private final FoodRepository foodRepository;
    private final RestClient restClient;

    public FoodServiceImpl(ModelMapper modelMapper, FoodRepository foodRepository, RestClient restClient) {
        this.modelMapper = modelMapper;
        this.foodRepository = foodRepository;
        this.restClient = restClient;
    }

    @Override
    public FoodDTO getById(Long id) {
        return restClient.get().uri("/food/{id}", id).retrieve().body(FoodDTO.class);
    }

    @Override
    public Food findByName(String name) {
        Optional<Food> optFood = foodRepository.findByName(name);
        if (optFood.isEmpty()) {
            throw new FoodNotFoundException();
        }

        return optFood.get();
    }

    @Override
    public FoodDTO getByName(String name) {
        Food food = this.findByName(name);
        return restClient.get().uri("/food/{id}", food.getName()).retrieve().body(FoodDTO.class);
    }

    @Override
    public FoodDTO createFood(CreateFoodDTO createFoodDTO) {
        return restClient.post().uri("/food").body(createFoodDTO).retrieve().body(FoodDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        restClient.delete().uri("/food/{id}", id);
    }

    @Override
    public FoodDTO updateFood(Long id, UpdateFoodDTO updateFoodDTO) {
        return restClient.put().uri("/food/{id}", id).body(updateFoodDTO).retrieve().body(FoodDTO.class);
    }
}
