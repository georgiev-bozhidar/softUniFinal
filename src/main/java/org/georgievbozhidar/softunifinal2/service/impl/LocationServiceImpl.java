package org.georgievbozhidar.softunifinal2.service.impl;

import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateLocationDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.LocationDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.update.UpdateLocationDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Location;
import org.georgievbozhidar.softunifinal2.exception.LocationNotFoundException;
import org.georgievbozhidar.softunifinal2.repository.LocationRepository;
import org.georgievbozhidar.softunifinal2.service.ChainService;
import org.georgievbozhidar.softunifinal2.service.LocationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final ModelMapper modelMapper;
    private final ChainService chainService;
    private final RestClient restClient;

    public LocationServiceImpl(LocationRepository locationRepository, ModelMapper modelMapper, ChainService chainService, RestClient restClient) {
        this.locationRepository = locationRepository;
        this.modelMapper = modelMapper;
        this.chainService = chainService;
        this.restClient = restClient;
    }

    @Override
    public LocationDTO getById(Long id) {
        return restClient.get().uri("/location/{id}", id).retrieve().body(LocationDTO.class);
    }

    @Override
    public Location findByAddress(String address) {
        Optional<Location> optLocation = locationRepository.findByAddress(address);
        if (optLocation.isEmpty()) {
            throw new LocationNotFoundException();
        }

        return optLocation.get();
    }

    @Override
    public LocationDTO getByAddress(String address) {
        Location location = this.findByAddress(address);
        return restClient.get().uri("/location/{id}", location.getId()).retrieve().body(LocationDTO.class);
    }

    @Override
    public LocationDTO createLocation(CreateLocationDTO createLocationDTO) {
        return restClient.post().uri("/location").body(createLocationDTO).retrieve().body(LocationDTO.class);
    }

    @Override
    public LocationDTO updateLocation(Long id, UpdateLocationDTO updateLocationDTO) {
        return restClient.patch().uri("/food/{id}", id).body(updateLocationDTO).retrieve().body(LocationDTO.class);
    }

    @Override
    public void deleteLocation(Long id) {
        restClient.delete().uri("/location/{id}", id);
    }
}
