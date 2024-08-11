package org.georgievbozhidar.softunifinal2.controller;

import jakarta.validation.Valid;
import org.georgievbozhidar.softunifinal2.entity.dto.UserDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.create.UserRegisterDTO;
import org.georgievbozhidar.softunifinal2.entity.dto.update.UpdateUserDTO;
import org.georgievbozhidar.softunifinal2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id:\\d+}")
    public ModelAndView viewUserById(@PathVariable Long id){
        ModelAndView mnv = new ModelAndView("user-profile");

        UserDTO userDTO = userService.getById(id);
        mnv.addObject("userData", userDTO);

        return mnv;
    }

    @GetMapping("/users/{username:.\\D.*}")
    public ModelAndView viewUserByUsername(@PathVariable("username") String username){
        ModelAndView mnv = new ModelAndView("user-profile");

        UserDTO userDTO = userService.getByUsername(username);
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

    @PatchMapping("/users/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody @Valid UpdateUserDTO updateUserDTO){
        userService.updateUser(id, updateUserDTO);
        return "redirect:/users/" + id;
    }

}

