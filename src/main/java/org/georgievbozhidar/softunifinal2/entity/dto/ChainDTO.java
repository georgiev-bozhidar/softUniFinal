package org.georgievbozhidar.softunifinal2.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.georgievbozhidar.softunifinal2.entity.model.Location;
import org.georgievbozhidar.softunifinal2.entity.model.User;

import java.util.Set;

public class ChainDTO {
    @NotBlank
    private String name;

    private User owner;
    private Set<Location> locations;
}
