package org.georgievbozhidar.softunifinal2.controller;

import jakarta.validation.Valid;
import org.georgievbozhidar.softunifinal2.entity.dto.LocationDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateLocationDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.update.UpdateLocationDTO;
import org.georgievbozhidar.softunifinal2.service.ChainService;
import org.georgievbozhidar.softunifinal2.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/locations")
public class LocationController {
    private final LocationService locationService;
    private final ChainService chainService;

    public LocationController(LocationService locationService, ChainService chainService) {
        this.locationService = locationService;
        this.chainService = chainService;
    }

    @ModelAttribute("locationCreationData")
    public CreateLocationDTO createLocationCreationData(){
        return new CreateLocationDTO();
    }

//    @GetMapping("/{id}")
//    public ModelAndView viewLocation(@PathVariable Long id){
//        ModelAndView mnv = new ModelAndView("location");
//
//        LocationDTO locationDTO = locationService.getById(id);
//        mnv.addObject("locationData", locationDTO);
//
//        return mnv;
//    }

    @PostMapping
    public String createLocation(@RequestBody @Valid CreateLocationDTO createLocationDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        // TODO fix
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.locationData", bindingResult);
            redirectAttributes.addFlashAttribute("locationCreationData", createLocationDTO);

            return "redirect:/locations/create";
        }

        LocationDTO locationDTO = locationService.getByAddress(createLocationDTO.getAddress());

        return String.format("redirect:/chains/%s/locations/%s", locationDTO.getOwnedBy().getId(), locationDTO.getId());
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
        Long chainId = locationService.getById(id).getOwnedBy().getId();
        locationService.deleteLocation(id);
        return String.format("redirect:/chains/%s", chainId);
    }
}
