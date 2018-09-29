package com.progression.progressioncapstone.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsController {

    @GetMapping("/us")
    public String returnAboutUsPage() {
        return "about-us";
    }

}



