package org.georgievbozhidar.softunifinal2.entity.dto.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.georgievbozhidar.softunifinal2.entity.dto.ChainDTO;
import org.georgievbozhidar.softunifinal2.entity.enums.LocationType;

public class UpdateLocationDTO {
    private String address;

    @JsonProperty("ownedBy")
    private ChainDTO ownedBy;

    private LocationType locationType;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ChainDTO getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(ChainDTO ownedBy) {
        this.ownedBy = ownedBy;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }
}
