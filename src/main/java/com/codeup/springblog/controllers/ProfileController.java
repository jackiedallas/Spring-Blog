package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {

    @GetMapping("/profile{username}")
    public String welcome(@PathVariable String username, Model model) {
        model.addAttribute("viewUsername", username);
        return "profile";
    }

    @GetMapping("/profile/{name}")
    public String welcomeBack(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "profile";
    }
}
