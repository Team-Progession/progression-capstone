package com.progression.progressioncapstone.Controllers;

import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeContrloller {

    @GetMapping("/")
    public String returnHomePage() {
        return "home";
    }

}