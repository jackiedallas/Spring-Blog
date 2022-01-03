package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    @ResponseBody
    public String welcome(){return "Welcome back User.";}

    @GetMapping("/profile/{name}")
    public String welcomeBack(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "profile";
    }
}
