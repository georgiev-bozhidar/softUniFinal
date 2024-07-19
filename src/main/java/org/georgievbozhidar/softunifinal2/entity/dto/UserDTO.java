package org.georgievbozhidar.softunifinal2.entity.dto;

import jakarta.validation.constraints.NotBlank;
import org.georgievbozhidar.softunifinal2.entity.model.Chain;

import java.util.Set;

public class UserDTO {
    @NotBlank
    private String username;

    @NotBlank
    private String email;

    private Set<Chain> ownedChains;

    private Set<Chain> favouriteChains;
}
