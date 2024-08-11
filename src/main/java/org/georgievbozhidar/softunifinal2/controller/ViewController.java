package org.georgievbozhidar.softunifinal2.controller;

import org.georgievbozhidar.softunifinal2.entity.dto.ChainDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.UserLoginDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateChainDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.CreateLocationDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.UserRegisterDTO;
import org.georgievbozhidar.softunifinal2.service.ChainService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Set;

@Controller
public class ViewController {
    private final ChainService chainService;

    public ViewController(ChainService chainService) {
        this.chainService = chainService;
    }

    @ModelAttribute("loginData")
    public UserLoginDTO getLoginData() {
        return new UserLoginDTO();
    }

    @ModelAttribute("registerData")
    public UserRegisterDTO getRegisterData() {
        return new UserRegisterDTO();
    }

    @ModelAttribute("chainCreationData")
    public CreateChainDTO createChainCreationData(){
        return new CreateChainDTO();
    }

    @ModelAttribute("locationCreationData")
    public CreateLocationDTO createLocationCreationData(){
        return new CreateLocationDTO();
    }

    @GetMapping("/")
    public String viewIndex(Authentication authentication){
        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            return "redirect:/home";
        }

        return "index";
    }

    @GetMapping("/home")
    public String viewHome(Authentication authentication){
        if (authentication != null && !authentication.isAuthenticated() && authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/";
        }

        return "home";
    }
    @GetMapping("/login")
    public String viewLogin(){
        return "login";
    }

    @GetMapping("/register")
    public String viewRegister(){
        return "register";
    }

    @GetMapping("/search")
    public String viewSearch(Model model){
        Set<ChainDTO> chainDTOs = chainService.getAllChains();
        model.addAttribute("chainDTOs", chainDTOs);

        return "search";
    }

    @GetMapping("/cart")
    public String viewCart(){
        return "cart";
    }

    @GetMapping("/chains/create")
    public String viewChainCreate(){
        return "create-chain";
    }

    @GetMapping("/locations/create")
    public String viewLocationCreate(){
        return "create-location";
    }

//    @GetMapping("/account/order-history")
//    public String viewOrderHistory(){
//        return "order-history";
//    }

//    @GetMapping("/account/settings")
//    public String viewUserSettings(){
//        return "user-settings";
//    }
}
