package com.codeup.springblog.controllers;

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

    // view posts
    @GetMapping("/posts")
    @ResponseBody
    public String viewPosts(Model model) {
        ArrayList<Post> posts = new ArrayList<>();

        Post post1 = new Post("Title 1", "Body 1");
        Post post2 = new Post("Title 2", "Body 2");

        posts.add(post1);
        posts.add(post2);

        model.addAttribute("posts", posts);

        return "/" + posts;
    }

    // view individual post
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewSinglePost(@PathVariable int id, Model model) {
        Post post = new Post("Title", "Body");
        model.addAttribute("post", post);
        return post + "/" + id;
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
