package org.georgievbozhidar.softunifinal2.entity.dto.update;

import org.georgievbozhidar.softunifinal2.entity.enums.DrinkType;

public class UpdateDrinkDTO {
    private String name;

    private DrinkType drinkType;

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
