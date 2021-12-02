package com.findme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    //@RequestMapping(path = "/", method = RequestMethod.GET)
   @GetMapping(path = "/")
    public String home() {
        return "index";
    }

}
