package org.georgievbozhidar.softunifinal2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    @GetMapping("/error")
    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handleException(RuntimeException e) {
        ModelAndView modelAndView = new ModelAndView("error");

        modelAndView.addObject("exception", e.getMessage());

        return modelAndView;
    }
}
