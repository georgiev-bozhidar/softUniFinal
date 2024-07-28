package org.georgievbozhidar.softunifinal2.entity.dto.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.georgievbozhidar.softunifinal2.entity.dto.UserDTO;

public class UpdateChainDTO {
    private String name;

    @JsonProperty("owner")
    private UserDTO owner;

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDTO getOwner() {
        return owner;
    }

    public void setOwner(UserDTO owner) {
        this.owner = owner;
    }
}
