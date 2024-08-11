package org.georgievbozhidar.softunifinal2.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.georgievbozhidar.softunifinal2.entity.dto.ChainDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateChainDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateDrinkDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateFoodDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateLocationDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.update.UpdateChainDTO;
import org.georgievbozhidar.softunifinal2.service.ChainService;
import org.georgievbozhidar.softunifinal2.service.LocationService;
import org.georgievbozhidar.softunifinal2.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Set;

@Controller
@RequestMapping("/chains")
public class ChainController {
    private final ChainService chainService;
    private final UserService userService;
    private final RestClient restClient;
    private final LocationService locationService;

    public ChainController(ChainService chainService, UserService userService, RestClient restClient, LocationService locationService) {
        this.chainService = chainService;
        this.userService = userService;
        this.restClient = restClient;
        this.locationService = locationService;
    }

    @ModelAttribute("chainCreationData")
    public CreateChainDTO createChainCreationData(){
        return new CreateChainDTO();
    }

//    @ModelAttribute("locationCreationData")
//    public CreateLocationDTO createLocationCreationData(){
//        return new CreateLocationDTO();
//    }
//
//    @ModelAttribute("foodCreationData")
//    public CreateFoodDTO createFoodCreationData(){
//        return new CreateFoodDTO();
//    }
//
//    @ModelAttribute("drinkCreationData")
//    public CreateDrinkDTO createDrinkCreationData(){
//        return new CreateDrinkDTO();
//    }

//    @ModelAttribute("chainUpdateData")
//    public UpdateChainDTO createChainUpdateData(){
//        return new UpdateChainDTO();
//    }

    @GetMapping("/{id}")
    public ModelAndView viewChain(@PathVariable Long id) {
        ModelAndView mnv = new ModelAndView("chain");

        ChainDTO chainDTO = chainService.getById(id);
        mnv.addObject("chainData", chainDTO);

        return mnv;
    }

    @GetMapping("/all")
    public String viewAllChains() {
        return "redirect:/search";
    }

    @GetMapping("/{chainId}/locations/{locationId}")
    public ModelAndView viewLocation(@PathVariable Long chainId, @PathVariable Long locationId){
        ModelAndView mnv = new ModelAndView("location");

        mnv.addObject("locationData", locationService.getById(locationId));

        return mnv;
    }

    @PostMapping
    public String doCreateChain(@RequestBody @Valid CreateChainDTO createChainDTO, Authentication authentication, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        // TODO fix
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.chainCreationData", bindingResult);
            redirectAttributes.addFlashAttribute("chainCreationData", createChainDTO);

            return "redirect:/chains/create";
        }

        ChainDTO chainDTO = chainService.createChain(createChainDTO, authentication.getName());
        model.addAttribute("chainCreationData", chainDTO);

        return String.format("redirect:/chains/%s", chainDTO.getId());
    }

//    @PatchMapping("/{id}")
//    public String updateChain(@PathVariable Long id, @RequestBody @Valid UpdateChainDTO updateChainDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.chainUpdateData", bindingResult);
//            redirectAttributes.addFlashAttribute("chainUpdateData", updateChainDTO);
//
//            return "redirect:/chains/id";
//        }
//        chainService.updateChain(id, updateChainDTO);
//        return "redirect:/chains/" + id;
//    }

    @DeleteMapping("/{id}")
    public String doDeleteChain(@PathVariable Long id, Authentication authentication) {
        chainService.deleteChain(id);
        return String.format("redirect:/users/%s", userService.findByUsername(authentication.getName()));
    }


}
