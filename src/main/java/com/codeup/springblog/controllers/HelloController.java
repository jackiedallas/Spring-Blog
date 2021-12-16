package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello from quasar";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "Hello there " + name + "!";
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return "Your number plus one is " + (number + 1) + ".";
    }

    @GetMapping("/")
    @ResponseBody
    public String landingPage() {
        return "<h1>This is a Landing Page</h1>";
    }
}
