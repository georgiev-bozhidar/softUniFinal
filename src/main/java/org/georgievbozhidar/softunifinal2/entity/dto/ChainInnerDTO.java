package org.georgievbozhidar.softunifinal2.entity.dto;

import jakarta.validation.constraints.NotBlank;

public class ChainInnerDTO {
    @NotBlank
    private Long id;

    @NotBlank
    private String name;

    public @NotBlank Long getId() {
        return id;
    }

    public void setId(@NotBlank Long id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }
}
