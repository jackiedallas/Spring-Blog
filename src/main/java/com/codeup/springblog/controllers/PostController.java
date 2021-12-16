package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    // view posts
    @GetMapping("/posts")
    @ResponseBody
    public String viewPosts() {
        return "posts";
    }

    // view individual post
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewSinglePost(@PathVariable int id) {
        return "posts/" + id;
    }

    // create posts
    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "posts/create";
    }

    // create new post
    @PostMapping("/posts/create")
    @ResponseBody
    public String postPosts() {
        return "posts/create";
    }


}
