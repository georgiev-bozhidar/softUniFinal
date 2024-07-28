package org.georgievbozhidar.softunifinal2.controller;

import jakarta.validation.Valid;
import org.georgievbozhidar.softunifinal2.entity.dto.DrinkDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.LocationDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateLocationDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.update.UpdateDrinkDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.update.UpdateLocationDTO;
import org.georgievbozhidar.softunifinal2.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
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
    public ModelAndView getLocation(@PathVariable Long id){
        ModelAndView mnv = new ModelAndView("location");

        mnv.addObject("locationData", locationService.getById(id));

        return mnv;
    }

    @PostMapping
    public ModelAndView createLocation(@RequestBody CreateLocationDTO createLocationDTO){
        ModelAndView mnv = new ModelAndView("location");

        LocationDTO locationDTO = locationService.createLocation(createLocationDTO);
        mnv.addObject("locationData", locationDTO);

        return mnv;
    }

    @PatchMapping("/{id}")
    public ModelAndView updateLocation(@PathVariable Long id, @RequestBody @Valid UpdateLocationDTO updateLocationDTO) {
        ModelAndView mnv = new ModelAndView("location");

        LocationDTO locationDTO = locationService.updateLocation(id, updateLocationDTO);
        mnv.addObject("locationData", locationDTO);

        return mnv;
    }

    @DeleteMapping("/{id}")
    public String deleteLocation(@PathVariable Long id){
        locationService.deleteLocation(id);
        return "redirect:/home";
    }
}
