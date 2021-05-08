package org.comrades.springtime.controller.rest;


import org.comrades.springtime.customExceptions.UserNotFoundException;
import org.comrades.springtime.module.Post;
import org.comrades.springtime.module.User;
import org.comrades.springtime.module.requested.PostDto;
import org.comrades.springtime.servise.PostService;
import org.comrades.springtime.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "https://pdfmarkov.github.io")
@RestController
@RequestMapping("/main/app/**")
public class MainController {

    private final PostService postService;
    private final UserService userService;

    @Autowired
    public MainController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody PostDto postDto) {
        Map<Object, Object> response = new HashMap<>();

        Post post = new Post();

        post.setText(postDto.getText());
        post.setTitle(postDto.getTitle());

        User user = userService.getCurrentUser();
        try {
            user = userService.findByUsername(postDto.getLogin());
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }

        post.setUser(user);

        postService.savePost(post);

        post.setUser(null);

        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

    @PostMapping("/clear")
    public ResponseEntity clear() {
        User user = userService.getCurrentUser();
        postService.clearByUser(user);
        return ResponseEntity.ok("");
    }

    @PostMapping("/hello")
    public ResponseEntity hello(String login) {
        Map<Object, Object> response = new HashMap<>();
        List<Post> posts = new ArrayList<>();
        try {
            posts = postService.getPostsByUser(userService.findByUsername(login));
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(posts);

    }

    @PostMapping("/all")
    public ResponseEntity getAllPostsWithUsers() {
        List<User> users = userService.getAllUsers();
        List<User> data = new ArrayList<>();
        for(User user : users) {
            user.setPostList(null);
            List<Post> posts = postService.getPostsByUser(user);
            for(Post post : posts) {
                post.setUser(null);
            }
            user.setPostList(posts);
            data.add(user);
        }
        return ResponseEntity.ok(data);
    }

}
