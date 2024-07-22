package org.georgievbozhidar.softunifinal2.entity.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateFoodDTO {
    @NotBlank
    private String name;

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }
}