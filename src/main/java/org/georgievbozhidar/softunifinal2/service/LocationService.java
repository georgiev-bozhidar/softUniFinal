package org.georgievbozhidar.softunifinal2.service;

import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateLocationDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.LocationDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.update.UpdateLocationDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Location;

public interface LocationService {
    Location findByAddress(String address);
    LocationDTO getById(Long id);
    LocationDTO getByAddress(String address);

    LocationDTO createLocation(CreateLocationDTO createLocationDTO);

    LocationDTO updateLocation(Long id, UpdateLocationDTO updateLocationDTO);

    void deleteLocation(Long id);
}
