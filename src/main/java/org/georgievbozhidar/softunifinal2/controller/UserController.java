package org.georgievbozhidar.softunifinal2.controller;

import jakarta.validation.Valid;
import org.georgievbozhidar.softunifinal2.entity.dto.UserDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.UserLoginDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.UserRegisterDTO;
import org.georgievbozhidar.softunifinal2.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public ModelAndView viewUser(@PathVariable Long id){
        ModelAndView mnv = new ModelAndView("user-profile");

        UserDTO userDTO = userService.getById(id);
        mnv.addObject("userData", userDTO);

        return mnv;
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserRegisterDTO userRegisterDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginData", bindingResult);
            redirectAttributes.addFlashAttribute("registerData", userRegisterDTO);

            return "redirect:/register";
        }

        userService.createUser(userRegisterDTO);

        return "redirect:/login";
    }
}

