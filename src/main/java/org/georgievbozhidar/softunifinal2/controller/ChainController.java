package org.georgievbozhidar.softunifinal2.controller;

import jakarta.validation.Valid;
import org.georgievbozhidar.softunifinal2.entity.dto.ChainDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.ChainOwnerDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateChainDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateDrinkDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateFoodDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateLocationDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.update.UpdateChainDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.update.UpdateDrinkDTO;
import org.georgievbozhidar.softunifinal2.service.ChainService;
import org.georgievbozhidar.softunifinal2.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class ChainController {
    private final ChainService chainService;
    private final UserService userService;
    private final RestClient restClient;

    public ChainController(ChainService chainService, UserService userService, RestClient restClient) {
        this.chainService = chainService;
        this.userService = userService;
        this.restClient = restClient;
    }

    @ModelAttribute("chainCreationData")
    public CreateChainDTO createChainCreationData(){
        return new CreateChainDTO();
    }

    @ModelAttribute("locationCreationData")
    public CreateLocationDTO createLocationCreationData(){
        return new CreateLocationDTO();
    }

    @ModelAttribute("foodCreationData")
    public CreateFoodDTO createFoodCreationData(){
        return new CreateFoodDTO();
    }

    @ModelAttribute("drinkCreationData")
    public CreateDrinkDTO createDrinkCreationData(){
        return new CreateDrinkDTO();
    }

    @GetMapping("/chain/{id}")
    public ModelAndView viewChain(@PathVariable Long id) {
        ModelAndView mnv = new ModelAndView("chain");

        ChainDTO chainDTO = chainService.getById(id);
        mnv.addObject("chainData", chainDTO);

        return mnv;
    }

    @GetMapping("/chain/all")
    public String viewAllChains() {
        Set<ChainDTO> chainDTOs = chainService.getAllChains();
        return null; //TODO
    }

    @PostMapping
    public String doCreateChain(@RequestBody @Valid CreateChainDTO createChainDTO, Authentication authentication){
        ChainDTO chainDTO = chainService.createChain(createChainDTO, authentication.getName());
        return String.format("redirect:/chain/%s", chainDTO.getId());
    }

    @PatchMapping
    public String updateChain(@PathVariable Long id, @RequestBody @Valid UpdateChainDTO updateChainDTO) {
        chainService.updateChain(id, updateChainDTO);
        return "redirect:/chain/" + id;
    }

    @DeleteMapping("/{id}")
    public String doDeleteChain(@PathVariable Long id, Authentication authentication) {
        chainService.deleteChain(id);
        return String.format("redirect:/user/%s", userService.findByUsername(authentication.getName()));
    }
}
