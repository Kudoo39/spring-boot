package com.example.application.user;

import com.example.domain.user.User;
import com.example.infrastructure.user.IUserJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class    AuthenticationService {
    @Autowired
    private IUserJpaRepo _userRepo;
    @Autowired
    private PasswordEncoder _passwordEncoder;
    @Autowired
    private JwtService _jwtService;
    @Autowired
    private AuthenticationManager _authenticationManager;

    public String register(User incomingUser) {
        User user = new User();
        user.setName(incomingUser.getName());
        user.setUsername(incomingUser.getUsername());
        user.setPassword(_passwordEncoder.encode(incomingUser.getPassword()));

        user = _userRepo.save(user);

        return _jwtService.generateToken(user);
    }

    public String login(User request){
        _authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        User user = _userRepo.findUserByUsername(request.getUsername()).orElseThrow();
        return _jwtService.generateToken(user);
    }
}
