package org.comrades.springtime.controller.rest;

import org.comrades.springtime.customExceptions.UserNotFoundException;
import org.comrades.springtime.module.Post;
import org.comrades.springtime.module.Role;
import org.comrades.springtime.module.User;
import org.comrades.springtime.module.requested.AuthenticationRequestDto;
import org.comrades.springtime.module.requested.LoginDto;
import org.comrades.springtime.module.requested.ParamDto;
import org.comrades.springtime.module.requested.TestAuthenticationRequestDto;
import org.comrades.springtime.security.jwt.TokenHandler;
import org.comrades.springtime.servise.EmailService;
import org.comrades.springtime.servise.PostService;
import org.comrades.springtime.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NonUniqueResultException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "https://pdfmarkov.github.io")
@RestController
@RequestMapping("/api/aunt/**")
public class AuthorizationController {

    private final AuthenticationManager authenticationManager;
    private final TokenHandler jwtTokenProvider;
    private final UserService userService;
    private final EmailService emailService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final Code codeGenerator;
    private final PostService postService;

    @Autowired
    public AuthorizationController(AuthenticationManager authenticationManager, TokenHandler jwtTokenProvider, UserService userService, EmailService emailService, BCryptPasswordEncoder passwordEncoder, Code codeGenerator, PostService postService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
        this.codeGenerator = codeGenerator;
        this.postService = postService;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody TestAuthenticationRequestDto testAuthenticationRequestDto) {
        Map<Object, Object> response = new HashMap<>();
        try {
            String username = testAuthenticationRequestDto.getLogin();
            String password = testAuthenticationRequestDto.getPassword();
            String course = testAuthenticationRequestDto.getCourse();
            String group = testAuthenticationRequestDto.getGroup();
            String firstname = testAuthenticationRequestDto.getFirstname();
            String secondname = testAuthenticationRequestDto.getSecondname();
            String role = testAuthenticationRequestDto.getRole();

            User user = new User(username, password, firstname, secondname, group, course);
            user.addRole(Role.valueOf(role));

            String refreshToken = jwtTokenProvider.generateRefreshToken(user);
            user.setRefreshToken(refreshToken);

            String accessToken = jwtTokenProvider.generateAccessToken(user);

            try {
                userService.findByUsername(username);
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
            } catch (UserNotFoundException ex) {
                userService.saveUser(user);
            }

            Authentication auth = jwtTokenProvider.getAuthentication(accessToken);
            SecurityContextHolder.getContext().setAuthentication(auth);
            response.put("refreshToken", refreshToken);
            response.put("accessToken", accessToken);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (IncorrectResultSizeDataAccessException | NonUniqueResultException ex) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }
    }


    @PostMapping("/updatefirstname")
    public ResponseEntity updateFirstName(@RequestBody ParamDto paramDto) {
        Map<Object, Object> response = new HashMap<>();
        try {
            User user = userService.findByUsername(paramDto.getLogin());
            userService.updateFirstName(user,paramDto.getFirstname());
            response.put("firstname", userService.findByUsername(paramDto.getLogin()).getFirstname());
            return ResponseEntity.ok(response);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @PostMapping("/updatesecondname")
    public ResponseEntity updateSecondName(@RequestBody ParamDto paramDto) {
        Map<Object, Object> response = new HashMap<>();
        try {
            User user = userService.findByUsername(paramDto.getLogin());
            userService.updateSecondName(user,paramDto.getSecondname());
            response.put("secondname", userService.findByUsername(paramDto.getLogin()).getSecondname());
            return ResponseEntity.ok(response);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @PostMapping("/updategroup")
    public ResponseEntity updateGroup(@RequestBody ParamDto paramDto) {
        Map<Object, Object> response = new HashMap<>();
        try {
            User user = userService.findByUsername(paramDto.getLogin());
            userService.updateGroup(user,paramDto.getUsergroup());
            response.put("usergroup", userService.findByUsername(paramDto.getLogin()).getUsergroup());
            return ResponseEntity.ok(response);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @PostMapping("/updatephone")
    public ResponseEntity updatePhone(@RequestBody ParamDto paramDto) {
        Map<Object, Object> response = new HashMap<>();
        try {
            User user = userService.findByUsername(paramDto.getLogin());
            userService.updatePhone(user,paramDto.getPhone());
            response.put("phone", userService.findByUsername(paramDto.getLogin()).getPhone());
            return ResponseEntity.ok(response);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @PostMapping("/updateinfo")
    public ResponseEntity updateInfo(@RequestBody ParamDto paramDto) {
        Map<Object, Object> response = new HashMap<>();
        try {
            User user = userService.findByUsername(paramDto.getLogin());
            userService.updateInfo(user,paramDto.getInfo());
            response.put("phone", userService.findByUsername(paramDto.getLogin()).getInfo());
            return ResponseEntity.ok(response);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @PostMapping("/updatevk")
    public ResponseEntity updateVk(@RequestBody ParamDto paramDto) {
        Map<Object, Object> response = new HashMap<>();
        try {
            User user = userService.findByUsername(paramDto.getLogin());
            userService.updateInfo(user,paramDto.getVk());
            response.put("vk", userService.findByUsername(paramDto.getLogin()).getVk());
            return ResponseEntity.ok(response);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @PostMapping("/updatetg")
    public ResponseEntity updateTg(@RequestBody ParamDto paramDto) {
        Map<Object, Object> response = new HashMap<>();
        try {
            User user = userService.findByUsername(paramDto.getLogin());
            userService.updateInfo(user,paramDto.getTg());
            response.put("tg", userService.findByUsername(paramDto.getLogin()).getTg());
            return ResponseEntity.ok(response);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @PostMapping("/deleteuser")
    public ResponseEntity deleteUser(@RequestBody ParamDto paramDto) {
        Map<Object, Object> response = new HashMap<>();
        try {
            userService.delete(userService.findIdByLogin(paramDto.getLogin()));
            response.put("delete", userService.findIdByLogin(paramDto.getLogin()));
            return ResponseEntity.ok(response);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @PostMapping("/getinfo")
    public ResponseEntity getInfo(@RequestBody LoginDto loginDto) {
        Map<Object, Object> response = new HashMap<>();
        try {
            User user = userService.findByUsername(loginDto.getLogin());
            response.put("firstname", user.getFirstname());
            response.put("secondname", user.getSecondname());
            response.put("phone", user.getPhone());
            response.put("course", user.getCourse());
            response.put("usergroup", user.getUsergroup());
            response.put("info", user.getInfo());
            response.put("vk", user.getVk());
            response.put("tg", user.getTg());
            response.put("teamname", user.getTeamList().get(0).getName());
            List<Post> posts = postService.getPostsByUser(user);
            for(Post post : posts){
                post.setUser(null);
            }
            response.put("posts", posts);

            return ResponseEntity.ok(response);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }


    @PostMapping("/sign_in")
    public ResponseEntity signIn(@RequestBody AuthenticationRequestDto authenticationRequestDto) {
        Map<Object, Object> response = new HashMap<>();
        try {
            String username = authenticationRequestDto.getLogin();

            User user = userService.findByUsername(username);

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, authenticationRequestDto.getPassword()));

            String accessToken = jwtTokenProvider.generateAccessToken(user);

            response.put("refreshToken", user.getRefreshToken());
            response.put("accessToken", accessToken);

            return ResponseEntity.ok(response);
        }catch (UserNotFoundException | AuthenticationException ex) {
            if (ex instanceof UserNotFoundException) response.put("description", ex.getMessage());
            else response.put("description", "Wrong login or password.");

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }
    }

    @PostMapping("/getpassword")
    public ResponseEntity getPassword(@RequestBody LoginDto loginDto) {
        Map<Object, Object> response = new HashMap<>();
        try {
            codeGenerator.generateCode(loginDto.getLogin());
            String password = codeGenerator.getCode(loginDto.getLogin());
            emailService.sendSimpleMessage(loginDto.getLogin(), "Восстановления пароля. ITMO.TEAM", "Ваш новый пароль: " + password);
            User user = userService.findByUsername(loginDto.getLogin());
            userService.saveUser(user);
            return ResponseEntity.ok(response);
        }catch (UserNotFoundException | AuthenticationException ex) {
            if (ex instanceof UserNotFoundException) response.put("description", ex.getMessage());
            else response.put("description", "Wrong login or password.");

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }
    }



}
