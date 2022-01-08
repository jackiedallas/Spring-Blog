package com.codeup.springblog.controllers;

import com.codeup.springblog.interfaces.PostRepository;
import com.codeup.springblog.interfaces.UserRepository;
import com.codeup.springblog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;
    public PostController(PostRepository postDao, UserRepository userDao) {this.postDao = postDao; this.userDao = userDao;}
    public void editCreate(Post post) {
        post.setUsers(userDao.getById(1L));
        postDao.save(post);
    }

    // view posts
    @GetMapping("/posts/show")
    public String viewPosts(Model model) {
        model.addAttribute("user", userDao.findAll());
        model.addAttribute("posts", postDao.findAll());
        return "posts/show";
    }

    // view individual post
    @GetMapping("/posts/index/{id}")
    public String viewSinglePost(@PathVariable Long id, Model model) {

        Post singlePost = postDao.getById(id);
        model.addAttribute("user", singlePost.getUsers());
        model.addAttribute("post", singlePost);
        return "posts/index";
    }

    // show create posts
    @GetMapping("/posts/create")
    public String createPost(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    // create new post
    @PostMapping("/posts/create")
    public String postPosts(@ModelAttribute Post post) {
        editCreate(post);
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
    public String editPost(@ModelAttribute Post post) {
        editCreate(post);
        return "redirect:/posts/show";
    }

    // delete post by id
    @PostMapping("/delete-by-id/{id}")
    public String deletePostById(@PathVariable long id) {
        System.out.println(id);
        postDao.deleteById(id);
        return "redirect:/posts/show";
    }




}
