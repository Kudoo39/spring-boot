package com.example.presentation;

import com.example.application.user.AuthenticationService;
import com.example.application.user.IUserService;
import com.example.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private List<String> _users = new ArrayList<>(
            List.of("Kudoo", "Kune", "Khang", "I'mKudoo")
    );

    @Autowired
    private IUserService _userService;

    @Autowired
    private AuthenticationService _authService;

    @GetMapping
    public List<String> getAll() {
        return _userService.getAll();
    }

    @PostMapping("/register")
    public String signup(@RequestBody User user){
        return _authService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return _authService.login(user);
    }
}
