package org.georgievbozhidar.softunifinal2.service.impl;

import org.georgievbozhidar.softunifinal2.entity.dto.CreateFoodDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Food;
import org.georgievbozhidar.softunifinal2.repository.FoodRepository;
import org.georgievbozhidar.softunifinal2.service.FoodService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {
    private final ModelMapper modelMapper;
    private final FoodRepository foodRepository;

    public FoodServiceImpl(ModelMapper modelMapper, FoodRepository foodRepository) {
        this.modelMapper = modelMapper;
        this.foodRepository = foodRepository;
    }

    @Override
    public Food createFood(CreateFoodDTO createFoodDTO) {
        Food food = modelMapper.map(createFoodDTO, Food.class);
        foodRepository.save(food);
        return food;
    }

    @Override
    public void deleteFoodById(Long id) {
        Optional<Food> optFood = foodRepository.findById(id);
        if (optFood.isEmpty()){
            return;
        }

        foodRepository.delete(optFood.get());
    }

    @Override
    public Food getFoodById(Long id) {
        return foodRepository.findById(id).orElse(null);

    }
}
