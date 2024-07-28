package org.georgievbozhidar.softunifinal2.entity.dto.create;

import jakarta.validation.constraints.*;
import org.georgievbozhidar.softunifinal2.entity.model.Role;
import org.georgievbozhidar.softunifinal2.validation.annotation.UniqueEmail;
import org.georgievbozhidar.softunifinal2.validation.annotation.UniqueUsername;

import java.time.LocalDate;
import java.util.Collection;

public class UserRegisterDTO {
    @NotBlank(message = "Username must not be blank.")
    @Size(min = 2, max = 32, message = "Username must be between 2 and 32 characters long.")
    @UniqueUsername(message = "Username is already in use.")
    private String username;

    @NotBlank(message = "Password must not be blank.")
    @Size(min = 8, max = 30, message = "Password must be between 8 and 30 characters long.")
    private String password;

    @NotBlank(message = "Password confirmation must not be blank.")
    @Size(min = 8, max = 30, message = "Password must be between 8 and 30 characters long.")
    private String confirmPassword;

    @NotBlank(message = "Email must not be blank.")
    @Email(message = "Invalid email format.")
    @UniqueEmail(message = "Email is already in use.")
    private String email;

    @NotNull
    @PastOrPresent(message = "Invalid date.")
    private LocalDate birthday;

    private Collection<Role> roles;

    public UserRegisterDTO() {
    }

    public UserRegisterDTO(String username, String password, String confirmPassword, String email, LocalDate birthday, Collection<Role> roles) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.birthday = birthday;
        this.roles = roles;
    }

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

    public @NotBlank(message = "Password confirmation must not be blank.") @Size(min = 8, max = 30, message = "Password must be between 8 and 30 characters long.") String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(@NotBlank(message = "Password confirmation must not be blank.") @Size(min = 8, max = 30, message = "Password must be between 8 and 30 characters long.") String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public @NotBlank(message = "Email must not be blank.") @Email(message = "Invalid email format.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email must not be blank.") @Email(message = "Invalid email format.") String email) {
        this.email = email;
    }

    public @NotNull @PastOrPresent(message = "Invalid date.") LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(@NotNull @PastOrPresent(message = "Invalid date.") LocalDate birthday) {
        this.birthday = birthday;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
