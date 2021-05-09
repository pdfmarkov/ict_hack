package org.comrades.springtime.controller.rest;

import org.comrades.springtime.customExceptions.PostNotFoundException;
import org.comrades.springtime.customExceptions.UserNotFoundException;
import org.comrades.springtime.module.Post;
import org.comrades.springtime.module.Team;
import org.comrades.springtime.module.User;
import org.comrades.springtime.module.requested.*;
import org.comrades.springtime.servise.PostService;
import org.comrades.springtime.servise.TeamService;
import org.comrades.springtime.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "https://iuribabalin.github.io")
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
    public ResponseEntity add(@RequestBody PostDto postDto) throws UserNotFoundException, PostNotFoundException {
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
    public ResponseEntity clear() throws UserNotFoundException, PostNotFoundException {
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
        } catch (UserNotFoundException | PostNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
        return ResponseEntity.ok(posts);

    }

    @PostMapping("/all")
    public ResponseEntity getAllPostsWithUsers() throws UserNotFoundException, PostNotFoundException {
        List<User> users = userService.getAllUsers();
        List<OutputPost> data = new ArrayList<>();
        for (User user : users) {
            List<Post> posts = postService.getPostsByUser(user);
            for (Post post : posts) {
                OutputPost outputPost = new OutputPost();

                if (user.getTeamList().size() == 0) outputPost.setTeamname(null);
                else outputPost.setTeamname(user.getTeamList().get(0).getName());
                outputPost.setFirstname(user.getFirstname());
                outputPost.setSecondname(user.getSecondname());
                outputPost.setTime(post.getTime());
                outputPost.setText(post.getText());
                outputPost.setTitle(post.getTitle());

                if (user.getTeamList().size() != 0) {
                    List<Team> teamList = teamService.findByName(user.getTeamList().get(0).getName());
                    outputPost.setNumberOfMembers(teamList.size());
                }
                else outputPost.setNumberOfMembers(0);
                data.add(outputPost);
            }
        }
        data.sort(OutputPost::compareTo);

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
        } else return ResponseEntity.status(HttpStatus.FORBIDDEN).body("");
    }

    @PostMapping("/team/deletemember")
    public ResponseEntity deleteMember(@RequestBody TeamDto teamDto) {
        Map<Object, Object> response = new HashMap<>();
        teamService.clearByUser(teamDto.getName(), teamDto.getLogin());
        return ResponseEntity.ok("deleted");
    }

    @PostMapping("/deletepost")
    public ResponseEntity deletePost(@RequestBody TimeDto timeDto) throws PostNotFoundException {
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
        for (Team team : teamList) {
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

    @PostMapping("/team/info")
    public ResponseEntity getInfoAboutTeam(@RequestBody TeamDto teamDto) {
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

        if (teamList.size() != 0) {
//            Team team = new Team();
//            team.setUser(user);
//            team.setName(teamList.get(0).getName());
//            team.setLogin(user.getLogin());
//            team.setRole(user.getRoles().get(0).toString());
//            teamService.saveTeam(team);
//            team.setUser(null);

            response.put("teamname", teamList.get(0).getName());
            List<User> members = new ArrayList<>();
            User member;
            for (Team team : teamList) {
                try {
                    member = userService.findByUsername(team.getLogin());
                    member.setTeamList(null);
                    member.setPostList(null);
                    member.setPassword("nope");
                    member.setRefreshToken("nope");
                    members.add(member);
                } catch (UserNotFoundException e) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
                }
            }

            response.put("members", members);

            return ResponseEntity.ok(response);
        } else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
    }
}