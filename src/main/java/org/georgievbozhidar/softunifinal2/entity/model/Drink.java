package org.georgievbozhidar.softunifinal2.entity.model;

import jakarta.persistence.*;
import org.georgievbozhidar.softunifinal2.entity.enums.DrinkType;

@Entity
@Table(name = "drinks")
public class Drink extends Consumable {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DrinkType drinkType;

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(DrinkType drinkType) {
        this.drinkType = drinkType;
    }
}
