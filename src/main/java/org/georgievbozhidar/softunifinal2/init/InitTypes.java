package org.georgievbozhidar.softunifinal2.init;

import org.georgievbozhidar.softunifinal2.entity.enums.DrinkType;
import org.georgievbozhidar.softunifinal2.entity.enums.LocationType;
import org.georgievbozhidar.softunifinal2.entity.model.DrinkTypeEntity;
import org.georgievbozhidar.softunifinal2.entity.model.LocationTypeEntity;
import org.georgievbozhidar.softunifinal2.repository.DrinkTypeEntityRepository;
import org.georgievbozhidar.softunifinal2.repository.LocationTypeEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitTypes implements CommandLineRunner {
    private final DrinkTypeEntityRepository drinkTypeEntityRepository;
    private final LocationTypeEntityRepository locationTypeEntityRepository;

    public InitTypes(DrinkTypeEntityRepository drinkTypeEntityRepository, LocationTypeEntityRepository locationTypeEntityRepository) {
        this.drinkTypeEntityRepository = drinkTypeEntityRepository;
        this.locationTypeEntityRepository = locationTypeEntityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (drinkTypeEntityRepository.count() > 0) {
            return;
        }

        DrinkType[] drinkTypes = DrinkType.values();
        for (DrinkType drinkType : drinkTypes) {
            DrinkTypeEntity drinkTypeEntity = new DrinkTypeEntity();
            drinkTypeEntity.setDrinkType(drinkType);
            drinkTypeEntityRepository.save(drinkTypeEntity);
        }

        if (locationTypeEntityRepository.count() > 0) {
            return;
        }

        LocationType[] locationTypes = LocationType.values();
        for (LocationType locationType : locationTypes) {
            LocationTypeEntity locationTypeEntity = new LocationTypeEntity();
            locationTypeEntity.setLocationType(locationType);
            locationTypeEntityRepository.save(locationTypeEntity);
        }
    }
}
