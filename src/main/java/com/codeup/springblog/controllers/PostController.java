package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;
    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {this.postDao = postDao; this.userDao = userDao; this.emailService = emailService;}
    public void editCreate(Post post) {
        post.setUsers(userDao.getById(1L));
        postDao.save(post);
    }


    // view create user
    @GetMapping("/posts/register")
    public String viewCreateUser(Model model) {
        model.addAttribute("user", new User());
        return "posts/register";
    }

    // create user
    @PostMapping("/posts/register")
    public String createUser(@ModelAttribute User user) {
        userDao.save(user);
        return "redirect:/posts/show";
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
        String emailSubject = post.getUsers().getUsername() + ", your post has been created!";
        String emailBody = "Congrats, your latest blog is up and ready to view on Spring Blog, it read: " + post.getBody();

        emailService.prepareAndSend(post, emailSubject, emailBody);
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

    // login
    @GetMapping("/posts/login")
    public String login() {
        return "posts/login";
    }




}
