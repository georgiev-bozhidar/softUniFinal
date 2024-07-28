package org.georgievbozhidar.softunifinal2.entity.model;

import jakarta.persistence.*;
import org.georgievbozhidar.softunifinal2.entity.enums.DrinkType;

@Entity
@Table(name = "drinks")
public class Drink extends Consumable {
    @Column(nullable=false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DrinkType drinkType;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(DrinkType drinkType) {
        this.drinkType = drinkType;
    }
}
