package org.georgievbozhidar.softunifinal2.entity.model;

import jakarta.persistence.*;
import org.georgievbozhidar.softunifinal2.entity.enums.LocationType;

@Entity
@Table(name = "location_types")
public class LocationTypeEntity extends BaseEntity {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LocationType locationType;

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }
}
