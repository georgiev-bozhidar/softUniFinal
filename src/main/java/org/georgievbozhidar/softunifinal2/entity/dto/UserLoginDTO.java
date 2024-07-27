package org.georgievbozhidar.softunifinal2.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLoginDTO {
    @NotBlank(message = "Username must not be blank.")
    @Size(min = 2, max = 32, message = "Username must be between 2 and 32 characters long.")
    private String username;

    @NotBlank(message = "Password must not be blank.")
    @Size(min = 8, max = 30, message = "Password must be between 8 and 30 characters long.")
    private String password;

    public @NotBlank(message = "Username must not be blank.") @Size(min = 2, max = 32, message = "Username must be between 2 and 32 characters long.") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Username must not be blank.") @Size(min = 2, max = 32, message = "Username must be between 2 and 32 characters long.") String username) {
        this.username = username;
    }

    public @NotBlank(message = "Password must not be blank.") @Size(min = 8, max = 30, message = "Password must be between 8 and 30 characters long.") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password must not be blank.") @Size(min = 8, max = 30, message = "Password must be between 8 and 30 characters long.") String password) {
        this.password = password;
    }
}
