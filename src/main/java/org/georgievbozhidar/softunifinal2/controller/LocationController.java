package org.georgievbozhidar.softunifinal2.controller;

import org.georgievbozhidar.softunifinal2.entity.dto.CreateLocationDTO;
import org.georgievbozhidar.softunifinal2.entity.model.Location;
import org.georgievbozhidar.softunifinal2.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/location")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @ModelAttribute("locationCreationData")
    public CreateLocationDTO createLocationCreationData(){
        return new CreateLocationDTO();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable Long id){
        Location location = locationService.getById(id);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody CreateLocationDTO createLocationDTO){
        Location location = locationService.createLocation(createLocationDTO);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }
}
