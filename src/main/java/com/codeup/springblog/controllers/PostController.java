package com.codeup.springblog.controllers;

import com.codeup.springblog.interfaces.PostRepository;
import com.codeup.springblog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;
    public PostController(PostRepository postDao) {this.postDao = postDao;}

    // view posts
    @GetMapping("/posts/show")
    public String viewPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/show";
    }

    // view individual post
    @GetMapping("/posts/index/{id}")
    public String viewSinglePost(@PathVariable Long id, Model model) {
        model.addAttribute("id", postDao.findById(id));
        return "posts/index";
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

    // delete post by id
    @PostMapping("/delete-by-id/{id}")
    public String deletePostById(@PathVariable long id) {
        System.out.println(id);
        postDao.deleteById(id);
        return "redirect:/posts/show";
    }



}
