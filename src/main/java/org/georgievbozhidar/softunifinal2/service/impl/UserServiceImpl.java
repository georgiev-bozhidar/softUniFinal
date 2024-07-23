package org.georgievbozhidar.softunifinal2.service.impl;

import org.georgievbozhidar.softunifinal2.entity.model.*;
import org.georgievbozhidar.softunifinal2.repository.*;
import org.georgievbozhidar.softunifinal2.service.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
//    private final ChainRepository chainRepository;
//    private final LocationRepository locationRepository;
//    private final FoodRepository foodRepository;
//    private final DrinkRepository drinkRepository;
//    private final ChainService chainService;
//    private final LocationService locationService;
//    private final FoodService foodService;
//    private final DrinkService drinkService;

//    public UserServiceImpl(UserRepository userRepository, ChainRepository chainRepository, LocationRepository locationRepository, FoodRepository foodRepository, DrinkRepository drinkRepository, ChainService chainService, LocationService locationService, FoodService foodService, DrinkService drinkService) {
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.chainRepository = chainRepository;
//        this.locationRepository = locationRepository;
//        this.foodRepository = foodRepository;
//        this.drinkRepository = drinkRepository;
//        this.chainService = chainService;
//        this.locationService = locationService;
//        this.foodService = foodService;
//        this.drinkService = drinkService;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }


    @Override
    public void order() {

    }

    @Override
    public void checkout() {

    }

}
