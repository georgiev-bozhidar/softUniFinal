package org.georgievbozhidar.softunifinal2.controller;

import jakarta.validation.Valid;
import org.georgievbozhidar.softunifinal2.entity.dto.CreateChainDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.CreateLocationDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestClient;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ViewController {


    @GetMapping("/")
    public String viewIndex(){
        return "index";
    }

    @GetMapping("/home")
    public String viewHome(){
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

    @ModelAttribute("chainCreationData")
    public CreateChainDTO createChainCreationData(){
        return new CreateChainDTO();
    }

    @ModelAttribute("locationCreationData")
    public CreateLocationDTO createLocationCreationData(){
        return new CreateLocationDTO();
    }

    @GetMapping("/chain/create")
    public String viewCreateChain(@Valid CreateChainDTO createChainDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        return "create-chain";
    }

    @GetMapping("/location/create")
    public String viewCreateLocation(@Valid CreateLocationDTO createLocationDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        return "create-location";
    }

    @GetMapping("/search")
    public String viewSearch(){
        return "search";
    }

    @GetMapping("/error")
    public String viewError(){
        return "error";
    }

    @GetMapping("/cart")
    public String viewCart(){
        return "cart";
    }

    @GetMapping("/account/order-history")
    public String viewOrderHistory(){
        return "order-history";
    }

    @GetMapping("/user/{id}/view")
    public ModelAndView viewUser(@PathVariable Long id, RestClient restClient){
        ModelAndView modelAndView = new ModelAndView("user-profile");
        modelAndView.addObject("user", restClient.get()
                .uri("http://localhost:8080/user/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(UserDTO.class));

        System.out.println(restClient.get().uri("/user/{id}", id).retrieve().body(String.class));
        return modelAndView;
    }

    @GetMapping("/account/settings")
    public String viewUserSettings(){
        return "user-settings";
    }

    @GetMapping("/chain/{id}/view")
    public ModelAndView viewChain(@PathVariable Long id, RestClient restClient){
        ModelAndView modelAndView = new ModelAndView("chain");
        modelAndView.addObject("chain", restClient.get().uri("http://localhost:8080/chain/{id}", id));

        return modelAndView;
    }

    @GetMapping("/location/{id}/view")
    public ModelAndView viewLocation(@PathVariable Long id, RestClient restClient){
        ModelAndView modelAndView = new ModelAndView("location");
        modelAndView.addObject("location", restClient.get().uri("http://localhost:8080/location/{id}", id));

        return modelAndView;
    }
}
