package org.georgievbozhidar.softunifinal2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e){
        ModelAndView mnv = new ModelAndView("error");
        mnv.addObject("exception", e.getMessage());

        return mnv;
    }
}
