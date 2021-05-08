package org.comrades.springtime.controller.rest;

import org.comrades.springtime.customExceptions.UserNotFoundException;
import org.comrades.springtime.module.Post;
import org.comrades.springtime.module.Team;
import org.comrades.springtime.module.User;
import org.comrades.springtime.module.requested.PostDto;
import org.comrades.springtime.module.requested.TeamDto;
import org.comrades.springtime.module.requested.TimeDto;
import org.comrades.springtime.servise.PostService;
import org.comrades.springtime.servise.TeamService;
import org.comrades.springtime.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "https://pdfmarkov.github.io")
@RestController
@RequestMapping("/main/app/**")
public class MainController {

    private final PostService postService;
    private final UserService userService;
    private final TeamService teamService;

    @Autowired
    public MainController(PostService postService, UserService userService, TeamService teamService) {
        this.postService = postService;
        this.userService = userService;
        this.teamService = teamService;
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(post);
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
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

    @PostMapping("/team/add")
    public ResponseEntity addNewTeam(@RequestBody TeamDto teamDto) {
        Map<Object, Object> response = new HashMap<>();

        Team team = new Team();

        team.setName(teamDto.getName());
        User user = new User();
        List<Team> teamList = new ArrayList<>();

        try {
            teamList = teamService.findByName(teamDto.getName());
            user = userService.findByUsername(teamDto.getLogin());
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
        if (teamList.size() == 0) {
            team.setUser(user);
            team.setLogin(user.getLogin());
            team.setRole(user.getRoles().get(0).toString());
            teamService.saveTeam(team);
            team.setUser(null);
            return ResponseEntity.status(HttpStatus.CREATED).body(team);
        } else  return ResponseEntity.status(HttpStatus.FORBIDDEN).body("");
    }

    @PostMapping("/deletepost")
    public ResponseEntity deletePost(@RequestBody TimeDto timeDto) {
        Map<Object, Object> response = new HashMap<>();

        Post post = postService.findByTime(timeDto.getTime());
        postService.deletePost(post.getPostId());
        return ResponseEntity.ok("deleted");
    }

    @PostMapping("/team/member")
    public ResponseEntity addNewMember(@RequestBody TeamDto teamDto) {
        Map<Object, Object> response = new HashMap<>();

        List<Team> teamList = new ArrayList<>();
        User user = new User();

        try {
            user = userService.findByUsername(teamDto.getLogin());
            teamList = teamService.findByName(teamDto.getName());
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
        for (Team team: teamList) {
            if (user.getLogin().equals(team.getLogin()))
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("");
        }

        if (teamList.size() != 0) {
            Team team = new Team();
            team.setUser(user);
            team.setName(teamList.get(0).getName());
            team.setLogin(user.getLogin());
            team.setRole(user.getRoles().get(0).toString());

            teamService.saveTeam(team);
            team.setUser(null);

            return ResponseEntity.status(HttpStatus.CREATED).body(team);
        } else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
    }
}