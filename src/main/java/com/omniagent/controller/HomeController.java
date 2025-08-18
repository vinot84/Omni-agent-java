package com.omniagent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(org.springframework.ui.Model model) {
        return "index";
    }
}
