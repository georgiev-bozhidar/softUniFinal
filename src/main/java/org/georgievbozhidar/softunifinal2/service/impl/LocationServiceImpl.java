package org.georgievbozhidar.softunifinal2.service.impl;

import org.georgievbozhidar.softunifinal2.entity.dto.CreateLocationDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Location;
import org.georgievbozhidar.softunifinal2.repository.LocationRepository;
import org.georgievbozhidar.softunifinal2.service.ChainService;
import org.georgievbozhidar.softunifinal2.service.LocationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final ModelMapper modelMapper;
    private final ChainService chainService;

    public LocationServiceImpl(LocationRepository locationRepository, ModelMapper modelMapper, ChainService chainService) {
        this.locationRepository = locationRepository;
        this.modelMapper = modelMapper;
        this.chainService = chainService;
    }

    @Override
    public Location createLocation(CreateLocationDTO createLocationDTO) {
        Location location = modelMapper.map(createLocationDTO, Location.class);
        locationRepository.save(location);
        chainService.addLocationToChain(location, location.getOwnedBy());
        return location;
    }

    @Override
    public void deleteLocationById(Long id) {
        Optional<Location> optLocation = locationRepository.findById(id);
        if (optLocation.isEmpty()) {
            return;
        }

        locationRepository.delete(optLocation.get());
    }

    @Override
    public Location getById(Long id) {

        //TODO add exception
        return locationRepository.findById(id).get();
    }
}
