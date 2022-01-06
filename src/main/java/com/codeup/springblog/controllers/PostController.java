package com.codeup.springblog.controllers;

import com.codeup.springblog.interfaces.PostRepository;
import com.codeup.springblog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        Post post = postDao.getById(id);
        model.addAttribute("post", post);
        return "posts/index";
    }

    // show create posts
    @GetMapping("/posts/create")
    public String createPost() {
        return "posts/create";
    }

    // create new post
    @PostMapping("/posts/create")
    public String postPosts(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
         Post newPost = new Post(title, body);
         postDao.save(newPost);

        return "redirect:/posts/show";
    }

    // delete post by id
    @PostMapping("/delete-by-id/{id}")
    public String deletePostById(@PathVariable long id) {
        System.out.println(id);
        postDao.deleteById(id);
        return "redirect:/posts/show";
    }

    // view edit post
    @GetMapping("posts/edit/{id}")
    public String viewEditPost(@PathVariable Long id, Model model) {
        Post post = postDao.getById(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    // edit post
    @PostMapping("/edit/{id}")
    public String editPost(@PathVariable("id") Long id, @RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        Post editPost = new Post(title, body, id);
        postDao.save(editPost);
        return "redirect:/posts/show";
    }



}
