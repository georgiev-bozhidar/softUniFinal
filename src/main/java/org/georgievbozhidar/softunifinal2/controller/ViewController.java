package org.georgievbozhidar.softunifinal2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/chain/create")
    public String viewCreateChain(){
        return "create-chain";
    }

    @GetMapping("/location/create")
    public String viewCreateLocation(){
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
    public String viewUser(@PathVariable Long id){
        return "user-profile";
    }

    @GetMapping("/account/settings")
    public String viewUserSettings(){
        return "user-settings";
    }

    @GetMapping("/chain/{id}/view")
    public String viewChain(@PathVariable Long id){
        return "chain";
    }

    @GetMapping("/location/{id}/view")
    public String viewLocation(@PathVariable Long id){
        return "location";
    }
}
