package org.georgievbozhidar.softunifinal2.entity.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.georgievbozhidar.softunifinal2.entity.enums.Roles;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity implements GrantedAuthority {
    @NotNull
    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private Roles roles;

    public @NotNull Roles getRoles() {
        return roles;
    }

    public void setRoles(@NotNull Roles roles) {
        this.roles = roles;
    }

    @Override
    public String getAuthority() {
        return String.valueOf(id);
    }
}
