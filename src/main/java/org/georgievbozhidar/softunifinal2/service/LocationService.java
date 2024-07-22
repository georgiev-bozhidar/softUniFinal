package org.georgievbozhidar.softunifinal2.service;

import org.georgievbozhidar.softunifinal2.entity.dto.CreateLocationDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Location;

public interface LocationService {
    Location createLocation(CreateLocationDTO createLocationDTO);
    void deleteLocationById(Long id);

    Location getById(Long id);
}
